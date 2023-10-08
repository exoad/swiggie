package pkg.exoad.swiggie.err;

/**
 * Used to signify some kind of reflection error where the desired method or reference that was supposed
 * to be found, was NOT found. For example, trying to get a constructor of a certain type, but not being able to find it
 * because the wrong class type was suggested.
 * <p>
 * Error type: Developer Induced
 */
public class SwUnexpectedReferenceTypingException
		extends RuntimeException
{
	public SwUnexpectedReferenceTypingException(String cause)
	{
		super(cause);
	}

	public SwUnexpectedReferenceTypingException(String cause, Throwable ref)
	{
		super(cause, ref);
	}
}
