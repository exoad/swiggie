package pkg.exoad.swiggie.tools.defs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a relation between two classes. This is mostly used for ease of a developer
 * using the framework to see whether two things can be used together and are intended by the developers
 * of the Swiggie framework to be used together.
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
public @interface SwRelatedTo
{
	Class<?>[] relations();
}
