package pkg.exoad.swiggie.stx;

import lombok.Getter;

@Getter public class SwImmutableI64
{
	public static SwImmutableI64 acquire(long value)
	{
		return new SwImmutableI64(value);
	}

	private final long value;

	private SwImmutableI64(long value)
	{
		this.value = value;
	}
}
