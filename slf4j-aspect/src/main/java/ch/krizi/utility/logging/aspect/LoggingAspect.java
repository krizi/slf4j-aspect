/**
 * 
 */
package ch.krizi.utility.logging.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.krizi.utility.logging.annotation.Log;
import ch.krizi.utility.logging.annotation.LogAll;
import ch.krizi.utility.logging.logger.LevelLogger;
import ch.krizi.utility.logging.logger.factory.LevelLoggerFactory;

/**
 * @author krizi
 * 
 */
@Aspect
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* *(..))")
	public void anyMethod() {
	}

	@Pointcut("!@annotation(ch.krizi.utility.logging.annotation.Log)")
	public void notLogAnnotaion() {
	}

	@Around("anyMethod() && @within(logAll) && notLogAnnotaion()")
	public Object aroundAllMethods(ProceedingJoinPoint joinPoint, LogAll logAll) throws Throwable {
		return aroundMethod(joinPoint, logAll.log());
	}

	@Around("anyMethod() && @annotation(log)")
	public Object aroundMethod(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
		return proceedJoinPoint(joinPoint, log);
	}

	private Object proceedJoinPoint(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		if (logger.isTraceEnabled()) {
			logger.trace("before Method [{}]", methodName);
		}
		Class<?> type = joinPoint.getTarget().getClass();
		LevelLogger classLogger = LevelLoggerFactory.createLogger(log.level(), type);
		Object returnValue = null;
		boolean exceptionThrown = false;
		try {
			if (log.logBeginEnd()) {
				List<MethodParameter> methodParameter = createParameter(signature, joinPoint.getArgs());
				if (log.logArguments() && !methodParameter.isEmpty()) {
					classLogger.log("begin Method [{}] with Parameter={}", methodName, methodParameter);
				} else {
					classLogger.log("begin Method [{}]", methodName);
				}
			}
			returnValue = joinPoint.proceed();
			return returnValue;
		} catch (Throwable t) {
			exceptionThrown = true;
			if (logger.isTraceEnabled()) {
				logger.trace("Method [{}] throws Exception [{}]", methodName, t);
			}
			if (log.logError()) {
				LevelLogger errorLogger = LevelLoggerFactory.createLogger(log.errorLevel(), type);
				errorLogger.log("Method [{}] throws unexpected error", methodName, t);
			}
			throw t;
		} finally {
			if (log.logBeginEnd()) {
				if (!isVoid(signature) && !exceptionThrown) {
					classLogger.log("end Method [{}] return=[{}]", methodName, returnValue);
				} else {
					classLogger.log("end [{}]", methodName);
				}
			}
			if (logger.isTraceEnabled()) {
				logger.trace("after Method [{}]", methodName);
			}
		}
	}

	private boolean isVoid(Signature signature) {
		if (signature instanceof MethodSignature) {
			MethodSignature methodSignature = (MethodSignature) signature;
			return "void".equals(methodSignature.getReturnType().toString());
		}
		return false;
	}

	/**
	 * create MethodParameter Objects representing the Method-Parameter (name, value, class)
	 * 
	 * @param signatur
	 * @param objects
	 * @return
	 */
	private List<MethodParameter> createParameter(Signature signatur, Object[] objects) {
		List<MethodParameter> params = new ArrayList<MethodParameter>();
		if (signatur instanceof CodeSignature) {
			CodeSignature codeSignature = (CodeSignature) signatur;
			for (int i = 0; i < objects.length; i++) {
				params.add(new MethodParameter(objects[i], codeSignature.getParameterTypes()[i], codeSignature
						.getParameterNames()[i]));
			}
		}
		return params;

	}
}
