package pkg.exoad.swiggie;

import lombok.Getter;
import lombok.Setter;
import pkg.exoad.swiggie.err.SwNonCompliantValuesException;
import pkg.exoad.swiggie.intf.SwSwappable;
import pkg.exoad.swiggie.tools.SwLog;

/**
 * A class that represents a size constraint
 */
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
		     .emitErrorOn(
				     width < 0 || height < 0,
				     SwNonCompliantValuesException.class,
				     "Width and Height of a size constraint cannot be negative! The value must be GREATER THAN OR EQUAL TO 0."
		     );
		return new SwSize(
				width,
				height
		);
	}

	/**
	 * Acquires a SwSize object with the given width
	 *
	 * @param width The width of the size
	 * @return A SwSize object with the given width
	 */
	public static SwSize acquireFromWidth(int width)
	{
		return acquire(
				width,
				0
		);
	}

	/**
	 * Acquires a SwSize object with the given height
	 *
	 * @param height The height of the size
	 * @return A SwSize object with the given height
	 */
	public static SwSize acquireFromHeight(int height)
	{
		return acquire(
				0,
				height
		);
	}

	private int width;
	private int height;

	/**
	 * Constructs a SwSize object with the given width and height
	 *
	 * @param width  The width of the size
	 * @param height The height of the size
	 */
	private SwSize(
			int width,
			int height
	)
	{
		this.width = width;
		this.height = height;
	}

	/**
	 * Calculates the area of the size
	 *
	 * @return The area of the size
	 */
	public int area()
	{
		return width * height;
	}

	/**
	 * Calculates the diagonal of the size as in a right triangle
	 *
	 * @return The diagonal of the size
	 */
	public float diagonal()
	{
		return (float) Math.sqrt(width * width + height * height);
	}

	/**
	 * Cascades the width
	 *
	 * @param width The width to cascade
	 * @return The SwSize object
	 */
	public static SwSize withWidth(int width)
	{
		return new SwSize(
				width,
				Integer.MAX_VALUE
		);
	}

	/**
	 * Cascades the height
	 *
	 * @param height The height to cascade
	 * @return The SwSize object
	 */
	public static SwSize withHeight(int height)
	{
		return new SwSize(
				Integer.MAX_VALUE,
				height
		);
	}

	/**
	 * Swaps the width and height
	 */
	@Override public void swap()
	{
		int tWidth = width;
		width = height;
		height = tWidth;
	}
}
