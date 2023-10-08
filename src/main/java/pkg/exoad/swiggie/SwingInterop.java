package pkg.exoad.swiggie;

import java.awt.*;

public final class SwingInterop
{
	private SwingInterop()
	{}

	public static Dimension size(SwSize size)
	{
		return new Dimension(size.getWidth(), size.getHeight());
	}

	public static Dimension size(int width, int height)
	{
		return new Dimension(width, height);
	}
}
