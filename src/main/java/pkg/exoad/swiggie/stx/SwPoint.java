package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class SwPoint
{
	private float x;
	private float y;

	private SwPoint(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public int xAsInt()
	{
		return (int) x;
	}

	public int yAsInt()
	{
		return (int) y;
	}
}
