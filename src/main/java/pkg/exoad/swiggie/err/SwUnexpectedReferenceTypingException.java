package pkg.exoad.swiggie.err;

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
