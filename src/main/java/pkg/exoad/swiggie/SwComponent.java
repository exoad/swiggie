package pkg.exoad.swiggie;

import javax.swing.*;

public class SwComponent
		extends JComponent
{
	public enum ComponentPropertyKey
	{
		DOUBLE_BUFFERED,
		OPAQUE,

	}

	public static SwComponent acquire()
	{
		return new SwComponent();
	}

	protected SwComponent()
	{
		super();
	}
}
