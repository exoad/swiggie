package pkg.exoad.swiggie.stx;

public class SwWrapper<T>
{
	public T value;

	public static <T> SwWrapper<T> acquire(T value)
	{
		return new SwWrapper<>(value);
	}

	private SwWrapper(T value)
	{
		this.value = value;
	}

	public T value()
	{
		return value;
	}

	public void value(T value)
	{
		this.value = value;
	}
}
