package pkg.exoad.swiggie.stx;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import pkg.exoad.swiggie.intf.SwSilentPipelineMember;

@Getter public class SwClampedValue<T extends Comparable<T>>
		extends SwClamped<T>
		implements
		SwSilentPipelineMember<T>
{
	private T value;

	private SwClampedValue(@NotNull T value, @NotNull T lower, @NotNull T upper)
	{
		super(lower, upper);
		this.value = value;
	}

	public void apply1(@NotNull T value)
	{
		this.value = super.apply(value);
	}

	public static <M extends Comparable<M>> SwClampedValue<M> acquireValue(M value, M lower, M upper)
	{
		return new SwClampedValue<>(value, lower, upper);
	}
}
