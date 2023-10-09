package pkg.exoad.swiggie;

import pkg.exoad.swiggie.err.SwNonCompliantValuesException;
import pkg.exoad.swiggie.stx.SwMap;
import pkg.exoad.swiggie.tools.SwLog;

import java.util.Optional;

public final class Swiggie
{
	private static Swiggie instance;

	public static Swiggie get()
	{
		if (instance == null)
			instance = new Swiggie();
		return instance;
	}

	private final SwMap<String, Object> launchFlags;

	private Swiggie()
	{
		launchFlags = new SwMap<>();
	}

	public long getVersion()
	{
		return 1L;
	}

	public long getVersionDate()
	{
		return 2023_09_30L;
	}

	public Optional<Object> getLaunchFlag(String key)
	{
		return launchFlags.onKeyEmpty(key);
	}

	public Swiggie useSwiggieLogging(boolean condition)
	{
		launchFlags.put("swiggie.useSwiggieLogging", Boolean.toString(condition));
		return this;
	}

	public Swiggie useGL()
	{
		launchFlags.put("sun.java2d.opengl", "true");
		return this;
	}

	public Swiggie useGLHeavy()
	{
		if (launchFlags.containsKey("sun.java2d.opengl") && launchFlags.get("sun.java2d.opengl")
		                                                               .toString()
		                                                               .equalsIgnoreCase("true"))
			SwLog.getLogger()
			     .emitError(SwNonCompliantValuesException.class,
					     "You cannot use the Java2D OpenGL inconjunction with the custom OpenGL wrapper. Make sure you are not calling useGL() and useGLHeavy() together!");
		else
			launchFlags.put("swiggie.useHeavyGL", "true");
		return this;
	}

	public boolean isSwiggieLogging()
	{
		return Boolean.parseBoolean((String) launchFlags.get("swiggie.useSwiggieLogging"));
	}

	public Swiggie arm()
	{
		launchFlags.forEach((k, v) -> System.setProperty(k, v.toString()));
		return this;
	}

}
