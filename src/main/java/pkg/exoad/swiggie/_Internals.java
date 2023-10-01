package pkg.exoad.swiggie;

final class _Internals
{
	public enum Logging
	{
		INIT, // initialization
		ERRN, // error
		KILL, // destruction
		RMVF, // removal forced
	}

	public static void log(Logging key, String content)
	{
		if(Swiggie.INSTANCE.getUseSwiggieDebugging())
			_Pre._stream.println("[" + key.name() + "]\t> " + content);
	}
}
