package pkg.exoad.swiggie.tests;

import pkg.exoad.swiggie.SwWindow;
import pkg.exoad.swiggie.Swiggie;

public class Scratchpad
{
	public static void main(String[] args)
	{
		Swiggie.get()
		       .useSwiggieLogging(true)
		       .useGLHeavy()
		       .arm();
		SwWindow.acquire()
		        .withTitle("Swiggie Test")
		        .withPreferredSized(800, 1050)
		        .onClose(SwWindow.SwWindowOnClose.EXIT)
		        .collateChildren()
		        .showComponent();
	}
}
