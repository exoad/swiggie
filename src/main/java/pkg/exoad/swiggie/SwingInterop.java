package pkg.exoad.swiggie;

import java.awt.*;

public final class SwingInterop
{
	private SwingInterop()
	{}

	public static Dimension size(Size size)
	{
		return new Dimension(size.width, size.height);
	}

	public static Dimension size(int width, int height)
	{
		return new Dimension(width, height);
	}
}
