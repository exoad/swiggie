package pkg.exoad.swiggie;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.WindowEvent;
import java.lang.ref.WeakReference;
import java.util.Optional;

public class SwWindowEv
	implements
		SwEventPayload<SwWindowEv.SwEventType, SwWindow>
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

	public static WeakReference<SwWindowEv> invoke(SwWindow source, SwEventType oldEvent, SwEventType newEvent)
	{
		return new WeakReference<>(new SwWindowEv(source, oldEvent, newEvent));
	}

	public static WeakReference<SwWindowEv> invoke(SwEventType oldEvent, SwEventType newEvent)
	{
		return new WeakReference<>((new SwWindowEv(oldEvent, newEvent)));
	}

	public static SwWindowEv invokeStrong(SwEventType oldEvent, SwEventType newEvent)
	{
		return new SwWindowEv(oldEvent, newEvent);
	}

	public static SwWindowEv invokeStrong(SwWindow source, SwEventType oldEvent, SwEventType newEvent)
	{
		return new SwWindowEv(source, oldEvent, newEvent);
	}

	@Nullable private final SwWindow source;
	private final SwEventType oldEvent;
	private final SwEventType newEvent;

	private SwWindowEv(@Nullable SwWindow source, SwEventType oldEvent, SwEventType newEvent)
	{
		this.source = source;
		this.oldEvent = oldEvent;
		this.newEvent = newEvent;
	}

	private SwWindowEv(SwEventType oldEvent, SwEventType newEvent)
	{
		this(null, oldEvent, newEvent);
	}

	@Nullable @Override public Optional<SwWindow> source()
	{
		return Optional.ofNullable(source);
	}

	@Override public SwEventType oldEvent()
	{
		return oldEvent;
	}

	@NotNull @Override public SwEventType newEvent()
	{
		return newEvent;
	}
}
