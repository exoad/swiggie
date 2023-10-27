package pkg.exoad.swiggie;

import pkg.exoad.swiggie.annot.SwDataContract;

@SwDataContract public class SwTransform
{
	private float angle;
	private float dx, dy;

	protected SwTransform(float dx, float dy)
	{
		this.dx = dx;
		this.dy = dy;
		this.angle = 0F;
	}

	protected SwTransform(float angle)
	{
		this.angle = angle;
		this.dx = dx;
		this.dy = dy;
	}
}
