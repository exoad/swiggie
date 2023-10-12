package pkg.exoad.swiggie;

import pkg.exoad.swiggie.stx.SwPoint;

public abstract class SwGeom
{
	private SwPoint origin;

	protected SwGeom(int originX, int originY)
	{
		this.origin = SwPoint.acquire(originX, originY);
	}

	abstract boolean contains(
			int x,
			int y
	);

	abstract boolean contains(SwPoint pt);

	abstract <T extends SwGeom> boolean contains(T geom);

}
