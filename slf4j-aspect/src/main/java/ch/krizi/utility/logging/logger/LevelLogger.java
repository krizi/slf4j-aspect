/**
 * 
 */
package ch.krizi.utility.logging.logger;

/**
 * @author krizi
 * 
 */
public interface LevelLogger {

	public void log(String msg);

	public void log(String msg, Object... params);

	public void log(String msg, Throwable throwable);
}
