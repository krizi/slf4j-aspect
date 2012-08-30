/**
 * 
 */
package ch.krizi.utility.logging;

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

	public void throwError() {
		throw new RuntimeException("runtaim");
	}

}
