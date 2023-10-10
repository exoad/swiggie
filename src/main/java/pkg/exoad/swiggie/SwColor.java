package pkg.exoad.swiggie;

import pkg.exoad.swiggie.intf.SwArithmetic;
import pkg.exoad.swiggie.stx.SwClampedValue;

public class SwColor
		implements SwArithmetic<SwColor>
{
	public static SwClampedValue<Integer> acquireRGBACompliant(int value)
	{
		return SwClampedValue.acquireValue(
				value,
				MIN_VALUE,
				MAX_VALUE
		);
	}

	public static SwColor acquireFromRGB(
			int r,
			int g,
			int b
	)
	{
		return new SwColor(
				r,
				g,
				b,
				MAX_VALUE
		);
	}

	public static SwColor acquireFromRGB(int rgb)
	{
		int red = (rgb >> 16) & 0xFF;
		int green = (rgb >> 8) & 0xFF;
		int blue = rgb & 0xFF;
		return SwColor.acquireFromRGB(
				red,
				green,
				blue
		);
	}

	public static SwColor acquireFromHEX(String hex)
	{
		if (hex.startsWith("#"))
			hex = hex.substring(1);
		int red = Integer.parseInt(
				hex.substring(
						0,
						2
				),
				16
		);
		int green = Integer.parseInt(
				hex.substring(
						2,
						4
				),
				16
		);
		int blue = Integer.parseInt(
				hex.substring(
						4,
						6
				),
				16
		);
		return acquireFromRGB(
				red,
				green,
				blue
		);
	}

	public static SwColor acquireFromARGB(int argb)
	{
		return new SwColor(argb);
	}

	public static SwColor acquireFromRGBA(
			int r,
			int g,
			int b,
			int a
	)
	{
		return new SwColor(
				r,
				g,
				b,
				a
		);
	}

	public static int MAX_VALUE = 255;
	public static int MIN_VALUE = 0;

	private final SwClampedValue<Integer> red;   // n / 255
	private final SwClampedValue<Integer> green; // n / 255
	private final SwClampedValue<Integer> blue;  // n / 255
	private final SwClampedValue<Integer> alpha; // n / 255

	private SwColor()
	{
		red = acquireRGBACompliant(0);
		green = acquireRGBACompliant(0);
		blue = acquireRGBACompliant(0);
		alpha = acquireRGBACompliant(0);
	}

	private SwColor(
			int r,
			int g,
			int b,
			int a
	)
	{
		this.red = acquireRGBACompliant(r);
		this.green = acquireRGBACompliant(g);
		this.blue = acquireRGBACompliant(b);
		this.alpha = acquireRGBACompliant(a);
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

	private SwColor(int argb)
	{
		this.alpha = acquireRGBACompliant((argb >> 24) & 0xFF);
		this.red = acquireRGBACompliant((argb >> 16) & 0xFF);
		this.green = acquireRGBACompliant((argb >> 8) & 0xFF);
		this.blue = acquireRGBACompliant(argb & 0xFF);
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

	public void setRed(int red)
	{
		this.red.apply1(red);
	}

	public void setGreen(int green)
	{
		this.green.apply1(green);
	}

	public void setBlue(int blue)
	{
		this.blue.apply1(blue);
	}

	public void setAlpha(int alpha)
	{
		this.alpha.apply1(alpha);
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

	public float[] asFloatArray()
	{
		return new float[] { red.getValue() / 255F, green.getValue() / 255F, blue.getValue() / 255F,
				alpha.getValue() / 255F };
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
