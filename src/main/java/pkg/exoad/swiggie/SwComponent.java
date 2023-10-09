package pkg.exoad.swiggie;

import pkg.exoad.swiggie.tools.defs.SwLayeredComponent;

import javax.swing.*;

@SwLayeredComponent
public abstract class SwComponent
	extends JComponent
{

	abstract void updateVisual();
}
