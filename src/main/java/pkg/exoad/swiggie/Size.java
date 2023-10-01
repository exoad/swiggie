package pkg.exoad.swiggie;

public class Size
	implements
		SwSwappable
{
	public int width;
	public int height;

	public Size(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public int area()
	{
		return width * height;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public static Size withWidth(int width)
	{
		return new Size(width, Integer.MAX_VALUE);
	}

	public static Size withHeight(int height)
	{
		return new Size(Integer.MAX_VALUE, height);
	}

	@Override public void swap()
	{
		int tWidth = width;
		width = height;
		height = tWidth;
	}
}
