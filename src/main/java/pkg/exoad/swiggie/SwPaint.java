package pkg.exoad.swiggie;

import java.awt.*;

public class SwPaint
{
	public static class SwAWTPaint
	{
		public static SwAWTPaint acquire(Graphics2D paint)
		{
			return new SwAWTPaint(paint);
		}

		private Graphics2D g2;

		private SwAWTPaint(Graphics2D paint)
		{

		}
	}
}
