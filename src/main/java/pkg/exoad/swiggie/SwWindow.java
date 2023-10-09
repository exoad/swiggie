package pkg.exoad.swiggie;

import org.jetbrains.annotations.NotNull;
import pkg.exoad.swiggie.dirt.SwIntendedCascade;
import pkg.exoad.swiggie.dirt.SwOptionalParam;
import pkg.exoad.swiggie.dirt.SwRequiredParam;
import pkg.exoad.swiggie.stx.SwVoidCallback;
import pkg.exoad.swiggie.tools.defs.SwTopLayerComponent;

import javax.swing.*;
import java.awt.*;

@SwTopLayerComponent
public class SwWindow
	extends SwComponent
{
	@Override void updateVisual()
	{

	}

	public enum SwWindowOnClose
	{
		NOTHING(WindowConstants.DO_NOTHING_ON_CLOSE),
		HIDE(WindowConstants.HIDE_ON_CLOSE),
		DISPOSE(WindowConstants.DISPOSE_ON_CLOSE),
		EXIT(WindowConstants.EXIT_ON_CLOSE);

		final int value;

		SwWindowOnClose(int internalValue)
		{
			value = internalValue;
		}
	}

	private JFrame _internal;
	private SwPane _pane;

	public static SwWindow acquire(@NotNull String windowName, @NotNull Integer width, @NotNull Integer height)
	{
		return new SwWindow(windowName, width, height);
	}

	public static SwWindow acquire()
	{
		return acquire("UnInit_SwWindow", 300, 300);
	}

	@SwRequiredParam(name = "windowName", type = "[char]")
	@SwOptionalParam(name = "width", type = "i32", defaultCall = "width[]:i32 -> 800;")
	@SwOptionalParam(name = "height", type = "i32", defaultCall = "height[]:i32 -> 600;")
	private SwWindow(@NotNull String windowName, int width, int height)
	{
		_internal = new JFrame();
		_internal.setTitle(windowName);
		_internal.getContentPane().setLayout(new BorderLayout());
		_internal.setPreferredSize(new Dimension(width, height));

		_pane = new SwPane();
	}

	@SwIntendedCascade public SwWindow withTitle(String name)
	{
		_internal.setTitle(name);
		return this;
	}

	@SwIntendedCascade public SwWindow withPreferredSized(int width, int height)
	{
		_internal.setPreferredSize(new Dimension(width, height));
		return this;
	}

	@SwIntendedCascade public SwWindow withSize(int width, int height)
	{
		_internal.setSize(new Dimension(width, height));
		return this;
	}

	@SwIntendedCascade public SwWindow withComponent(SwComponent... components)
	{
		for (SwComponent c : components)
			_pane.add(c);
		return this;
	}

	@SwIntendedCascade public SwWindow onClose(SwWindowOnClose suppliedOperation)
	{
		_internal.setDefaultCloseOperation(suppliedOperation.value);
		return this;
	}

	@SwIntendedCascade public SwWindow showComponent()
	{
		_internal.setVisible(true);
		return this;
	}

 	@SwIntendedCascade public SwWindow hideComponent()
	{
		_internal.setVisible(false);
		return this;
	}

	@SwIntendedCascade public SwWindow setVisibility(boolean visibility)
	{
		_internal.setVisible(visibility);
		return this;
	}

	@SwIntendedCascade public SwWindow collateChildren()
	{
		_internal.add(_pane, BorderLayout.CENTER);
		_internal.pack();
		_internal.setLocationRelativeTo(null);
		return this;
	}

	@SwIntendedCascade public SwWindow addWindowEventSubscriber(@NotNull SwWindowEv.SwEventType evenType, @NotNull SwVoidCallback<SwWindowEv> callback)
	{
		_internal.addWindowListener(SwWindowSubscriber.acquire().listenTo(evenType, callback).getAwtListener());
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowOpened(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.OPENED, callback);
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowClosed(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.CLOSED, callback);
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowClosing(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.CLOSING, callback);
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowActivated(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.ACTIVATED, callback);
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowIconified(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.ICONIFED, callback);
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowDeiconified(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.DEICONIFIED, callback);
		return this;
	}

	@SwIntendedCascade public SwWindow listenToWindowDeactivated(@NotNull SwVoidCallback<SwWindowEv> callback)
	{
		addWindowEventSubscriber(SwWindowEv.SwEventType.DEACTIVATED, callback);
		return this;
	}
}
