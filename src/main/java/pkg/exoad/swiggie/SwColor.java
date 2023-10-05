package pkg.exoad.swiggie;

import pkg.exoad.swiggie.intf.SwArithmetic;
import pkg.exoad.swiggie.stx.SwClampedValue;

public class SwColor
	implements SwArithmetic<SwColor>
{
	public static SwColor acquire(int r, int g, int b)
	{
		return new SwColor(r, g, b, MAX_VALUE);
	}

	public static int MAX_VALUE = 255;
	public static int MIN_VALUE = 0;

	private SwClampedValue<Integer> red;   // n / 255
	private SwClampedValue<Integer> green; // n / 255
	private SwClampedValue<Integer> blue;  // n / 255
	private SwClampedValue<Integer> alpha; // n / 255

	private SwColor()
	{
		red = SwClampedValue.acquireValue(0, MIN_VALUE, MAX_VALUE);
		green = SwClampedValue.acquireValue(0, MIN_VALUE, MAX_VALUE);
		blue = SwClampedValue.acquireValue(0, MIN_VALUE, MAX_VALUE);
		alpha = SwClampedValue.acquireValue(0, MIN_VALUE, MAX_VALUE);
	}

	private SwColor(int r, int g, int b, int a)
	{
		this.red = SwClampedValue.acquireValue(r, MIN_VALUE, MAX_VALUE);
		this.green = SwClampedValue.acquireValue(g, MIN_VALUE, MAX_VALUE);
		this.blue = SwClampedValue.acquireValue(b, MIN_VALUE, MAX_VALUE);
		this.alpha = SwClampedValue.acquireValue(a, MIN_VALUE, MAX_VALUE);
	}

	public int getRGBA()
	{
		return ((alpha.getValue() & 0xFF) << 24) |
				((red.getValue() & 0xFF) << 16) |
				((green.getValue() & 0xFF) << 8) |
				((blue.getValue() & 0xFF));
	}

	public int getRGB()
	{
		return ((red.getValue() & 0xFF) << 16) |
				((green.getValue() & 0xFF) << 8) |
				((blue.getValue() & 0xFF));
	}

	private SwColor(int rgb)
	{

	}

	public int getRed()
	{
		return red.getValue();
	}

	public int getGreen()
	{
		return green.getValue();
	}

	public int getBlue()
	{
		return blue.getValue();
	}

	public int getAlpha()
	{
		return alpha.getValue();
	}

	public float normalizeGreen()
	{
		return green.getValue() / (float) MAX_VALUE;
	}

	public float normalizeRed()
	{
		return red.getValue() / (float) MAX_VALUE;
	}

	public float normalizeBlue()
	{
		return blue.getValue() / (float) MAX_VALUE;
	}

	public float normalizeAlpha()
	{
		return alpha.getValue() / (float) MAX_VALUE;
	}

	@Override public SwColor add(SwColor other)
	{
		alpha.apply1(alpha.getValue() + other.getAlpha());
		red.apply1(red.getValue() + other.getRed());
		blue.apply1(blue.getValue() + other.getBlue());
		green.apply1(green.getValue() + other.getGreen());
		return this;
	}

	@Override public SwColor subtract(SwColor other)
	{
		alpha.apply1(alpha.getValue() - other.getAlpha());
		red.apply1(red.getValue() - other.getRed());
		blue.apply1(blue.getValue() - other.getBlue());
		green.apply1(green.getValue() - other.getGreen());
		return this;
	}

	@Override public SwColor multiply(SwColor other)
	{
		throw new ArithmeticException("Operation not permitted on a SwColor object");
	}

	@Override public SwColor divide(SwColor other)
	{
		throw new ArithmeticException("Operation not permitted on a SwColor object");
	}
}
