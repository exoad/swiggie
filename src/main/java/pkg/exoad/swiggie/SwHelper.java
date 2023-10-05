package pkg.exoad.swiggie;

import pkg.exoad.swiggie.stx.SwVoidCallback;

public final class SwHelper
{
	private SwHelper()
	{}

	public static SwVoidCallback<Void> emptyCallback()
	{
		return e -> {};
	}
}
