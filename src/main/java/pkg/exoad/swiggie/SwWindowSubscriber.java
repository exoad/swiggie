package pkg.exoad.swiggie;

import lombok.Getter;
import lombok.NonNull;
import pkg.exoad.swiggie.dirt.SwIntendedCascade;
import pkg.exoad.swiggie.stx.SwMap;
import pkg.exoad.swiggie.stx.SwVoidCallback;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SwWindowSubscriber
{
	public static SwWindowSubscriber acquire()
	{
		return new SwWindowSubscriber();
	}

	private final SwMap<SwWindowEv.SwEventType, SwVoidCallback<SwWindowEv>> listeners;
	@Getter private final WindowListener awtListener;

	private SwWindowSubscriber()
	{
		listeners = new SwMap<>();

		awtListener = new WindowListener()
		{
			@Override public void windowOpened(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.OPENED, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}

			@Override public void windowClosing(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.CLOSING, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}

			@Override public void windowClosed(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.CLOSED, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}

			@Override public void windowIconified(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.ICONIFED, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}

			@Override public void windowDeiconified(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.DEICONIFIED, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}

			@Override public void windowActivated(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.ACTIVATED, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}

			@Override public void windowDeactivated(WindowEvent e)
			{
				listeners.onKeyExist(SwWindowEv.SwEventType.DEACTIVATED, r -> r.call(
						SwWindowEv.invokeStrong(e.getSource(), SwWindowEv.acquire(e.getOldState()),
								SwWindowEv.acquire(e.getNewState()))));
			}
		};
	}

	@SwIntendedCascade public SwWindowSubscriber listenTo(@NonNull SwWindowEv.SwEventType type,
			@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listeners.put(type, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForOpened(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.OPENED, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForClosing(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.CLOSING, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForClosed(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.CLOSED, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForIconified(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.ICONIFED, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForDeiconified(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.DEICONIFIED, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForActivated(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.ACTIVATED, listener);
		return this;
	}

	@SwIntendedCascade public SwWindowSubscriber listenForDeactivated(@NonNull SwVoidCallback<SwWindowEv> listener)
	{
		listenTo(SwWindowEv.SwEventType.DEACTIVATED, listener);
		return this;
	}
}
