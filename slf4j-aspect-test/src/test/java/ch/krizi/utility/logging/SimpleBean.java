/**
 * 
 */
package ch.krizi.utility.logging;

import ch.krizi.utility.logging.annotation.Level;
import ch.krizi.utility.logging.annotation.Log;
import ch.krizi.utility.logging.annotation.LogAll;

/**
 * @author krizi
 * 
 */
@LogAll
public class SimpleBean {

	public SimpleBean() {

	}

	public Integer myMethod(int aNumber, String aString) {
		return -342452;
	}

	@Log(level = Level.Info)
	private void privateMethod() {
	}

	public void throwError() {
		privateMethod();
		throw new RuntimeException("runtaim");
	}

}
