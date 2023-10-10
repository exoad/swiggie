package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import pkg.exoad.swiggie.err.SwNonCompliantValuesException;
import pkg.exoad.swiggie.intf.SwPipelineMember;
import pkg.exoad.swiggie.intf.SwSwappable;
import pkg.exoad.swiggie.tools.SwLog;

@Getter public class SwClamped<T extends Comparable<T>>
		implements
		SwSwappable,
		SwPipelineMember<T>
{
	public static <M extends Comparable<M>> SwClamped<M> acquire(
			M lower,
			M upper
	)
	{
		return new SwClamped<>(
				lower,
				upper
		);
	}

	public static SwClamped<Integer> acquireUInt()
	{
		return new SwClamped<>(
				0,
				Integer.MAX_VALUE
		);
	}

	public static SwClamped<Float> acquireUFloat()
	{
		return new SwClamped<>(
				0.0F,
				Float.MAX_VALUE
		);
	}

	public static SwClamped<Byte> acquireUByte()
	{
		return new SwClamped<>(
				(byte) 0x0,
				Byte.MAX_VALUE
		);
	}

	public static SwClamped<Short> acquireUShort()
	{
		return new SwClamped<>(
				(short) 0,
				Short.MAX_VALUE
		);
	}

	public static SwClamped<Long> acquireULong()
	{
		return new SwClamped<>(
				0L,
				Long.MAX_VALUE
		);
	}

	@Setter T lower, upper;

	protected SwClamped(
			@NotNull T lower,
			@NotNull T upper
	)
	{
		if (lower.compareTo(upper) > 0) // the lower is greater than the upper
			SwLog.getLogger()
			     .emitError(
					     SwNonCompliantValuesException.class,
					     "The lower bound CANNOT be greater than the upper bound"
			     );
		this.lower = lower;
		this.upper = upper;
	}

	@Override public T apply(T value)
	{
		// assures a non nullable value is returned
		return value == null ? lower : value.compareTo(lower) < 0 ? lower : value.compareTo(upper) > 0 ? upper : value;
	}

	@Override public void swap()
	{
		T temp = lower;
		lower = upper;
		upper = temp;
	}
}
