package pkg.exoad.swiggie.err;

public class SwNonCompliantBoundsException
		extends RuntimeException
{

	public static void emitOn(String reason, boolean condition)
	{
		if (condition)
			throw new SwNonCompliantBoundsException(reason);
	}

	private SwNonCompliantBoundsException(String cause)
	{
		super(cause);
	}

	private SwNonCompliantBoundsException(String cause, Throwable throwable)
	{
		super(cause, throwable);
	}
}
