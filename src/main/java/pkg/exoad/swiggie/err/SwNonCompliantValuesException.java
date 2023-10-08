package pkg.exoad.swiggie.err;

/**
 * Used for most SwiggieLib's exceptions for when a value has an unexpected usage such as when a min and max are swapped for all the wrong reasons.
 * <p>
 * <p>
 * Error type: Developer Induced
 */
public class SwNonCompliantValuesException
		extends RuntimeException
{

	public static void emitOn(String reason, boolean condition)
	{
		if (condition)
			throw new SwNonCompliantValuesException(reason);
	}

	private SwNonCompliantValuesException(String cause)
	{
		super(cause);
	}

	private SwNonCompliantValuesException(String cause, Throwable throwable)
	{
		super(cause, throwable);
	}
}
