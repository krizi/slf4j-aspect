/**
 * 
 */
package ch.krizi.utility.logging.logger;

import org.slf4j.Logger;

/**
 * @author krizi
 * 
 */
public class InfoLogger extends AbstractLevelLogger {

	public InfoLogger(Logger classLogger) {
		super(classLogger);
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String)
	 */
	public void log(String msg) {
		if (classLogger.isInfoEnabled()) {
			classLogger.info(msg);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String, java.lang.Object[])
	 */
	public void log(String msg, Object... params) {
		if (classLogger.isInfoEnabled()) {
			classLogger.info(msg, params);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ch.krizi.utility.logging.logger.LevelLogger#log(java.lang.String, java.lang.Throwable)
	 */
	public void log(String msg, Throwable throwable) {
		if (classLogger.isInfoEnabled()) {
			classLogger.info(msg, throwable);
		}
	}

}
