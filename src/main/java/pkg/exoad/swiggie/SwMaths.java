package pkg.exoad.swiggie;

import pkg.exoad.swiggie.stx.SwPoint;
import pkg.exoad.swiggie.stx.SwVector2;

public final class SwMaths
{
	private SwMaths()
	{
	}

	/**
	 * Factor for converting from Radians to Degrees
	 */
	public static final float RAD_TO_DEG = (float) (180F / Math.PI);

	/**
	 * Factor for converting from Degrees to Radians
	 */
	public static final float DEG_TO_RAD = (float) (Math.PI / 180F);

	public static float distance(
			SwPoint p1,
			SwPoint p2
	)
	{
		return (float) Math.sqrt(Math.pow(
				p2.getY() - p1.getY(),
				2
		) + Math.pow(
				p2.getX() - p1.getY(),
				2
		));
	}

	public static SwVector2 asVector2(
			float theta,
			float mag
	)
	{
		return SwVector2.acquire(
				(float) (mag * Math.cos(theta)),
				(float) (mag * Math.sin(theta))
		);
	}
}
