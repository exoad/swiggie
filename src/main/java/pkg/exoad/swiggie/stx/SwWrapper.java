package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true) @Getter @Setter public class SwWrapper<T>
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
