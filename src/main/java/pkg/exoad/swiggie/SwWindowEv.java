package pkg.exoad.swiggie;

import java.awt.event.WindowEvent;

public class SwWindowEv
{
	public enum SwEventType
	{
		OPENED(WindowEvent.WINDOW_OPENED),
		CLOSING(WindowEvent.WINDOW_CLOSING),
		CLOSED(WindowEvent.WINDOW_CLOSED),
		ICONIFED(WindowEvent.WINDOW_ICONIFIED),
		DEICONIFIED(WindowEvent.WINDOW_DEICONIFIED),
		ACTIVATED(WindowEvent.WINDOW_ACTIVATED),
		DEACTIVATED(WindowEvent.WINDOW_DEACTIVATED),
		GAINED_FOCUS(WindowEvent.WINDOW_GAINED_FOCUS),
		LOST_FOCUS(WindowEvent.WINDOW_LOST_FOCUS);

		final int awtPayload;

		SwEventType(int payload)
		{
			this.awtPayload = payload;
		}
	}

	public record SwWindowPayload(SwEventType old, SwEventType now)
	{
	}

	
}
