/**
 * 
 */
package ch.krizi.utility.logging.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author krizi
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAll {
	Log log() default @Log();

	ElementType[] type() default { ElementType.METHOD };
}
