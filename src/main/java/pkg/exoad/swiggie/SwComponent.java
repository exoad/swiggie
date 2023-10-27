package pkg.exoad.swiggie;

import javax.swing.*;

public abstract class SwComponent
		extends JComponent
{
	public enum ComponentPropertyKey
	{
		DOUBLE_BUFFERED,
		OPAQUE,

	}

	abstract void updateVisual();

	public static SwComponent acquire()
	{
		return new SwComponent();
	}

	protected SwComponent()
	{
		super();
	}
}
