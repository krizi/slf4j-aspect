/**
 * 
 */
package ch.krizi.utility.logging.logger.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.krizi.utility.logging.annotation.Level;
import ch.krizi.utility.logging.logger.DebugLogger;
import ch.krizi.utility.logging.logger.ErrorLogger;
import ch.krizi.utility.logging.logger.InfoLogger;
import ch.krizi.utility.logging.logger.LevelLogger;
import ch.krizi.utility.logging.logger.TraceLogger;
import ch.krizi.utility.logging.logger.WarnLogger;
import ch.krizi.utility.logging.logger.exception.UnsupportedLoggerException;

/**
 * @author krizi
 * 
 */
public class LevelLoggerFactory {
	public static LevelLogger createLogger(Level lvl, Class<?> type) {
		Logger logger = LoggerFactory.getLogger(type);
		switch (lvl) {
			case Trace:
				return new TraceLogger(logger);
			case Debug:
				return new DebugLogger(logger);
			case Info:
				return new InfoLogger(logger);
			case Warn:
				return new WarnLogger(logger);
			case Error:
				return new ErrorLogger(logger);
		}
		throw new UnsupportedLoggerException("Level=" + lvl + " is not supported");
	}
}
