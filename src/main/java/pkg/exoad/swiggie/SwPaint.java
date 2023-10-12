package pkg.exoad.swiggie;

import pkg.exoad.swiggie.intf.SwPaintBatch;
import pkg.exoad.swiggie.intf.SwVoidCallback;
import pkg.exoad.swiggie.stx.SwPoint;
import pkg.exoad.swiggie.stx.SwVector2;
import pkg.exoad.swiggie.tools.SwLog;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public abstract class SwPaint<T>
{

	abstract T rectangle(
			SwPoint p1,
			SwPoint p2
	);

	abstract T rectangle(
			int x1,
			int y1,
			int x2,
			int y2
	);

	abstract T roundRectangle(
			SwPoint p1,
			SwPoint p2,
			int arcWidth,
			int arcHeight
	);

	abstract T roundRectangle(
			int x1,
			int y1,
			int x2,
			int y2,
			int arcWidth,
			int arcHeight
	);

	public static class SwAbsolutePaint
	{
		private SwVector2 origin;

	}

	/**
	 * This painter is a lazy Painter by default meaning draw commands are collected until they are necessary.
	 * <p>
	 * Ordering of the paint commands are ordered.
	 */
	public static class SwPainter
			extends SwPaint<SwPainter>
			implements
			SwPaintBatch<SwPainter>
	{
		private AtomicLong lastBatch = new AtomicLong(0);

		public static SwPainter acquire(Graphics2D paint)
		{
			return new SwPainter(paint);
		}

		private final ArrayList<SwVoidCallback<Graphics2D>> callbackCommands;
		private Graphics2D g2;

		private SwPainter(Graphics2D paint)
		{
			callbackCommands = new ArrayList<>();
		}

		/**
		 * Start command to prepare this painting batch for actually accepting paint commands.
		 *
		 * @return The current cascaded instance
		 */
		public synchronized SwPainter start()
		{
			if (callbackCommands.isEmpty())
				SwLog.getLogger()
				     .log(
						     SwLog.LogType.DBG,
						     "It is not necessary to start a paint batch twice."
				     );
			callbackCommands.clear();
			return this;
		}

		private synchronized SwPainter _submit(SwVoidCallback<Graphics2D> g2)
		{
			callbackCommands.add(g2);
			return this;
		}

		/**
		 * Collects all of the draw commands and uses all of the painting batch to paint it.
		 */
		public synchronized void end()
		{
			if (callbackCommands.isEmpty())
				SwLog.getLogger()
				     .log(
						     SwLog.LogType.DBG,
						     "There were no paint commands found! The last batch repaint occured: " + (
								     lastBatch.get() == 0 ? "0" : System.currentTimeMillis() - lastBatch.get())
								     + "ms ago."
				     );
			else
				callbackCommands.forEach(x -> x.call(g2));
		}

		public synchronized SwPainter useAntialiasing()
		{
			return _submit(g2 ->
					               g2.setRenderingHint(
							               RenderingHints.KEY_ANTIALIASING,
							               g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING)
									               == RenderingHints.VALUE_ANTIALIAS_ON ?
									               RenderingHints.VALUE_ANTIALIAS_OFF :
									               RenderingHints.VALUE_ANTIALIAS_ON
					               ));

		}

		public synchronized SwPainter colorTo(SwColor newColor)
		{
			return _submit(g2 -> g2.setColor(new Color(
					newColor.getRed(),
					newColor.getGreen(),
					newColor.getBlue(),
					newColor.getAlpha()
			)));
		}

		public synchronized SwPainter rectangle(
				SwPoint p1,
				SwPoint p2
		)
		{
			return _submit(g2 -> g2.drawRect(
					p1.xAsInt(),
					p1.yAsInt(),
					p2.xAsInt(),
					p2.yAsInt()
			));
		}

		@Override SwPainter rectangle(
				int x1,
				int y1,
				int x2,
				int y2
		)
		{
			return _submit(g2 -> g2.drawRect(
					x1,
					y1,
					x2,
					y2
			));
		}

		@Override SwPainter roundRectangle(
				SwPoint p1,
				SwPoint p2,
				int arcWidth,
				int arcHeight
		)
		{
			return this;
		}

		@Override SwPainter roundRectangle(
				int x1,
				int y1,
				int x2,
				int y2,
				int arcWidth,
				int arcHeight
		)
		{
			return this;
		}

	}
}
