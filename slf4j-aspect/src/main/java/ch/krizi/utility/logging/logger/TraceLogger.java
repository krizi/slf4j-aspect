/**
 * 
 */
package ch.krizi.utility.logging.logger;

import org.slf4j.Logger;

/**
 * @author krizi
 * 
 */
public class TraceLogger extends AbstractLevelLogger {

	public TraceLogger(Logger classLogger) {
		super(classLogger);
	}

	public void log(String msg) {
		if (classLogger.isTraceEnabled()) {
			classLogger.trace(msg);
		}
	}

	public void log(String msg, Object... params) {
		if (classLogger.isTraceEnabled()) {
			classLogger.trace(msg, params);
		}
	}

	public void log(String msg, Throwable throwable) {
		if (classLogger.isTraceEnabled()) {
			classLogger.trace(msg, throwable);
		}
	}

}
