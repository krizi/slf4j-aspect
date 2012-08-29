/**
 * 
 */
package ch.krizi.utility.logging.logger;

import org.slf4j.Logger;

/**
 * @author krizi
 * 
 */
public class WarnLogger extends AbstractLevelLogger {

	public WarnLogger(Logger classLogger) {
		super(classLogger);
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String)
	 */
	public void log(String msg) {
		if (classLogger.isWarnEnabled()) {
			classLogger.warn(msg);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String, java.lang.Object[])
	 */
	public void log(String msg, Object... params) {
		if (classLogger.isWarnEnabled()) {
			classLogger.warn(msg, params);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String, java.lang.Throwable)
	 */
	public void log(String msg, Throwable throwable) {
		if (classLogger.isWarnEnabled()) {
			classLogger.warn(msg, throwable);
		}
	}

}
