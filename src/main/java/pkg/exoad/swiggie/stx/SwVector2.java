package pkg.exoad.swiggie.stx;

import lombok.Getter;
import lombok.Setter;
import pkg.exoad.swiggie.SwMaths;

@Getter @Setter public class SwVector2
{
	public static SwVector2 acquire(
			float x,
			float y
	)
	{
		return new SwVector2(
				x,
				y
		);
	}

	private float x;
	private float y;

	protected SwVector2(
			float x,
			float y
	)
	{
		this.x = x;
		this.y = y;
	}

	public float length()
	{
		return (float) Math.sqrt(x * x + y * y);
	}

	public float distance(
			float x,
			float y
	)
	{
		return (float) Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
	}

	public float distance(SwVector2 other)
	{
		return (float) Math.sqrt((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y));
	}

	public float cross(
			float x,
			float y
	)
	{
		return this.x * y - this.y * x;
	}

	public float cross(SwVector2 other)
	{
		return this.x * other.y - this.y * other.x;
	}

	public SwVector2 subtract(
			float x,
			float y
	)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public SwVector2 subtract(SwVector2 other)
	{
		this.x -= other.x;
		this.y -= other.y;
		return this;
	}

	public SwVector2 add(
			float x,
			float y
	)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public SwVector2 add(SwVector2 other)
	{
		this.x += other.x;
		this.y += other.y;
		return this;
	}

	public float dot(
			float x,
			float y
	)
	{
		return this.x * x + this.y * y;
	}

	public float dot(SwVector2 other)
	{
		return this.x * other.x + this.y * other.y;
	}

	public float angleDegToX()
	{
		float e = (float) Math.atan2(
				y,
				x
		) * SwMaths.RAD_TO_DEG;
		return e < 0 ? e + 360 : e;
	}

	public float angleDegTo(SwVector2 other)
	{
		return (float) Math.atan2(
				cross(other),
				dot(other)
		) * SwMaths.RAD_TO_DEG;
	}

	public float angleRadToX()
	{
		return (float) Math.atan2(
				y,
				x
		);
	}

	public float angleRadTo(SwVector2 other)
	{
		return (float) Math.atan2(
				cross(other),
				dot(other)
		);
	}

}
