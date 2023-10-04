import pkg.exoad.swiggie.SwWindow;
import pkg.exoad.swiggie.Swiggie;

public class TestMain
{
	public static void main(String[] args)
	{
		Swiggie.INSTANCE.setUseSwiggieDebugging(true);
		Swiggie.INSTANCE.useGL().arm();

		SwWindow.acquire("A Random Window", 300, 300).onClose(SwWindow.SwWindowOnClose.EXIT).collateChildren().show();
	}
}
