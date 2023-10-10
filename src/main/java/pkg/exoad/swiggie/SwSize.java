package pkg.exoad.swiggie;

import lombok.Getter;
import lombok.Setter;
import pkg.exoad.swiggie.err.SwNonCompliantValuesException;
import pkg.exoad.swiggie.intf.SwSwappable;
import pkg.exoad.swiggie.tools.SwLog;

@Getter @Setter public class SwSize
		implements
		SwSwappable
{
	public static SwSize acquire(
			int width,
			int height
	)
	{
		SwLog.getLogger()
		     .emitErrorOn(width < 0 || height < 0,
		                  SwNonCompliantValuesException.class,
		                  "Width and Height of a size constraint cannot be negative! The value must be GREATER THAN OR EQUAL TO 0."
		     );
		return new SwSize(
				width,
				height
		);
	}

	public static SwSize acquireFromWidth(int width)
	{
		return acquire(
				width,
				0
		);
	}

	public static SwSize acquireFromHeight(int height)
	{
		return acquire(
				0,
				height
		);
	}

	private int width;
	private int height;

	private SwSize(
			int width,
			int height
	)
	{
		this.width = width;
		this.height = height;
	}

	public int area()
	{
		return width * height;
	}

	public float diagonal()
	{
		return (float) Math.sqrt(width * width + height * height);
	}

	public static SwSize withWidth(int width)
	{
		return new SwSize(
				width,
				Integer.MAX_VALUE
		);
	}

	public static SwSize withHeight(int height)
	{
		return new SwSize(
				Integer.MAX_VALUE,
				height
		);
	}

	@Override public void swap()
	{
		int tWidth = width;
		width = height;
		height = tWidth;
	}
}
