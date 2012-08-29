/**
 * 
 */
package ch.krizi.utility.logging.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author krizi
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
	Level level() default Level.Trace;

	Level errorLevel() default Level.Error;

	String message() default "";

	boolean logBeginEnd() default true;

	boolean logArguments() default true;

	boolean logError() default true;
}
