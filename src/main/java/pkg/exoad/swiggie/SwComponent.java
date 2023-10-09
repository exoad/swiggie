package pkg.exoad.swiggie;

import pkg.exoad.swiggie.tools.SwLayeredComponent;

import javax.swing.*;

@SwLayeredComponent
public abstract class SwComponent
	extends JComponent
{

	abstract void updateVisual();
}
