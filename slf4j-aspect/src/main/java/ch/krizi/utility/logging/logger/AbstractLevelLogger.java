/**
 * 
 */
package ch.krizi.utility.logging.logger;

import org.slf4j.Logger;

/**
 * @author krizi
 * 
 */
public abstract class AbstractLevelLogger implements LevelLogger {

	protected final Logger classLogger;

	public AbstractLevelLogger(Logger classLogger) {
		this.classLogger = classLogger;
	}

}
