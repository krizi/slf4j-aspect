/**
 * 
 */
package ch.krizi.utility.logging;

import org.junit.Test;

/**
 * @author krizi
 * 
 */
public class LoggingAllLogsTest {

	@Test
	public void testMyMethod() {
		new SimpleBean().myMethod(44, "anyString");
	}

	@Test(expected = RuntimeException.class)
	public void testThrowError() {
		new SimpleBean().throwError();
	}
}
