package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class SwWrapper<T>
{
	public static <T> SwWrapper<T> acquire(T value)
	{
		return new SwWrapper<>(value);
	}

	private T value;

	private SwWrapper(T value)
	{
		this.value = value;
	}
}
