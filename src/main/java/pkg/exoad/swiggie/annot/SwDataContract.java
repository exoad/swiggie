package pkg.exoad.swiggie.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class's primary goal is to hold data and hold
 * on to it until it can be applied to a pipeline member or another
 * object whom can use it.
 * This is especially useful for a simple concept like keeping
 * delta_x and delta_y in a transform data holder.
 * The reason it is named a contract is because Swiggie gurantees that
 * this Data holding class does not contain an unusable value.
 * <br>
 * A data contract cannot have logic implemented that affects it data
 * without the developer implementing said functionality. However a data
 * contract is allowed to calculate other parameters that do not affect values
 * that were given to it before.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface SwDataContract
{
}
