package pkg.exoad.swiggie;

import org.jetbrains.annotations.NotNull;
import pkg.exoad.swiggie.dirt.SwIntendedCascade;
import pkg.exoad.swiggie.dirt.SwOptionalParam;
import pkg.exoad.swiggie.dirt.SwRequiredParam;

import javax.swing.*;
import java.awt.*;

@SwTopLayerComponent
public class SwWindow
{
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

	@SwRequiredParam(name = "windowName", type = "[char]")
	@SwOptionalParam(name = "width", type = "i32", defaultCall = "width[]:i32 -> 800;")
	@SwOptionalParam(name = "height", type = "i32", defaultCall = "height[]:i32 -> 600;")
	private SwWindow(@NotNull String windowName, int width, int height)
	{
		_Internals.log(_Internals.Logging.INIT, "SwWindow: \"" + windowName + "," + width + "," + height + "\"");
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

	@SwIntendedCascade public SwWindow withPrefSize(int width, int height)
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

	public void show()
	{
		_internal.setVisible(true);
	}

	public void hide()
	{
		_internal.setVisible(false);
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

	@SwIntendedCascade public SwWindow onWindowEvent()
	{
		return this;
	}

}
