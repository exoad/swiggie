package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class SwWrapper<T>
{
	/**
	 * Acquire a value.
	 *
	 * @param value The value to acquire.
	 * @param <T>   The type of the value.
	 * @return The acquired value.
	 */
	public static <T> SwWrapper<T> acquire(T value)
	{
		return new SwWrapper<>(value);
	}

	private T value;

	/**
	 * Construct a new SwWrapper.
	 *
	 * @param value The value to wrap.
	 */
	private SwWrapper(T value)
	{
		this.value = value;
	}
}
