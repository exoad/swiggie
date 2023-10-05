import pkg.exoad.swiggie.SwWindow;
import pkg.exoad.swiggie.Swiggie;

public class TestMain
{
	public static void main(String[] args)
	{
		Swiggie.INSTANCE.setUseSwiggieDebugging(true);
		Swiggie.INSTANCE.useGL()
		                .arm();
		SwWindow.acquire()
				.withTitle("Swiggie Test")
				.withPreferredSized(800, 1050)
		        .onClose(SwWindow.SwWindowOnClose.EXIT)
		        .collateChildren()
		        .showComponent();
	}
}
