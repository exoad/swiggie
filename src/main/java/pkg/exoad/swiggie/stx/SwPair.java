package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.ref.WeakReference;

@Accessors(fluent = true) @Getter @Setter public class SwPair<A, B>
{
	public static <A, B> SwPair<A, B> acquire(
			A first,
			B second
	)
	{
		return new SwPair<>(
				first,
				second
		);
	}

	public static <A, B> WeakReference<SwPair<A, B>> acquireWeak(
			A first,
			B second
	)
	{
		return new WeakReference<>(new SwPair<>(
				first,
				second
		));
	}

	private A first;
	private B second;

	private SwPair(
			A first,
			B second
	)
	{
		this.first = first;
		this.second = second;
	}
}
