/**
 * 
 */
package ch.krizi.utility.logging.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author krizi
 * 
 */
@Target(ElementType.TYPE)
public @interface LogAll {
	Log value() default @Log();

	ElementType[] type() default { ElementType.METHOD };
}
