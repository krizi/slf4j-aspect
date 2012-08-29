/**
 * 
 */
package ch.krizi.utility.logging.logger;

import org.slf4j.Logger;

/**
 * @author krizi
 * 
 */
public class DebugLogger extends AbstractLevelLogger {

	public DebugLogger(Logger classLogger) {
		super(classLogger);
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String)
	 */
	public void log(String msg) {
		if (classLogger.isDebugEnabled()) {
			classLogger.debug(msg);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String, java.lang.Object[])
	 */
	public void log(String msg, Object... params) {
		if (classLogger.isDebugEnabled()) {
			classLogger.debug(msg, params);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String, java.lang.Throwable)
	 */
	public void log(String msg, Throwable throwable) {
		if (classLogger.isDebugEnabled()) {
			classLogger.debug(msg, throwable);
		}
	}
}
