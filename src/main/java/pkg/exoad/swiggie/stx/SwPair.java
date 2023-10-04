package pkg.exoad.swiggie.stx;

import pkg.exoad.swiggie.SwUnsafe;
import pkg.exoad.swiggie.intf.SwSwappable;

import java.lang.ref.WeakReference;

public class SwPair<A, B>
		implements SwSwappable
{
	public A first;
	public B second;

	public static <A, B> SwPair<A, B> acquire(A first, B second)
	{
		return new SwPair<>(first, second);
	}

	public static <A, B> WeakReference<SwPair<A, B>> acquireWeak(A first, B second)
	{
		return new WeakReference<>(new SwPair<>(first, second));
	}

	private SwPair(A first, B second)
	{
		this.first = first;
		this.second = second;
	}

	public A first()
	{
		return first;
	}

	public B second()
	{
		return second;
	}

	public void first(A first)
	{
		this.first = first;
	}

	public void second(B second)
	{
		this.second = second;
	}

	@SuppressWarnings("unchecked") @SwUnsafe(reason = "Unable to perform runtime type checking for generics on a Pair!") @Override public void swap()
	{
		Object temp = first;
		this.first = (A) second;
		this.second = (B) temp;
	}
}
