package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class SwPoint
{
	public static SwPoint acquire()
	{
		return acquire(0,
		               0);
	}

	public static SwPoint acquire(
			int x,
			int y
	)
	{
		return new SwPoint(
				x,
				y
		);
	}

	private float x;
	private float y;

	protected SwPoint(
			float x,
			float y
	)
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
