package pkg.exoad.swiggie.tools;

import java.lang.ref.WeakReference;

public final class SwObjects
{
	private SwObjects()
	{
	}

	public static <T> WeakReference<T> ofWeak(T object)
	{
		return new WeakReference<>(object);
	}
}
