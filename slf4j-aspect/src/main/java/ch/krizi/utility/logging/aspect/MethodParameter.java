/**
 * 
 */
package ch.krizi.utility.logging.aspect;

/**
 * @author krizi
 * 
 */
public class MethodParameter {
	private final Object object;
	private final Class<?> type;
	private final String name;

	public MethodParameter(Object object, Class<?> type, String name) {
		super();
		this.object = object;
		this.type = type;
		this.name = name;
	}

	public Object getObject() {
		return object;
	}

	public Class<?> getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + "=" + object;
	}

}
