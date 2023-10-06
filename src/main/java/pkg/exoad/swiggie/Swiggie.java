package pkg.exoad.swiggie;

import pkg.exoad.swiggie.stx.SwMap;

import java.util.Optional;

public final class Swiggie
{
	private static Swiggie instance;

	public static Swiggie get()
	{
		if(instance == null)
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
		launchFlags.put("sun.java2d.opengl", "True");
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
