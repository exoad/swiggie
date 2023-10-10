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

	/**
	 * Gets the current rolling version (Starts from 1
	 *
	 * @return The current version
	 */
	public long getVersion()
	{
		return 1L;
	}

	/**
	 * The date of the current version
	 *
	 * @return The date of the current version
	 * @see #getVersion()
	 */
	public long getVersionDate()
	{
		return 2023_09_30L;
	}

	/**
	 * Get all launch flags from the pre launch dictionary
	 *
	 * @param key The key to get the value from
	 * @return The value of the key
	 */
	public Optional<Object> getLaunchFlag(String key)
	{
		return launchFlags.onKeyEmpty(key);
	}

	public Swiggie useSwiggieLogging(boolean condition)
	{
		launchFlags.put(
				"swiggie.useSwiggieLogging",
				Boolean.toString(condition)
		);
		return this;
	}

	/**
	 * Use the inbuilt Java2D supplied OpenGL. This is not as stable.
	 *
	 * @return The Swiggie instance
	 */
	public Swiggie useGL()
	{
		launchFlags.put(
				"sun.java2d.opengl",
				"true"
		);
		return this;
	}

	/**
	 * Use a more hardware accelerated OpenGL Wrapper for Java2D. This is more stable.
	 *
	 * @return The Swiggie instance
	 */
	public Swiggie useGLHeavy()
	{
		if (launchFlags.containsKey("sun.java2d.opengl") && launchFlags.get("sun.java2d.opengl")
		                                                               .toString()
		                                                               .equalsIgnoreCase("true"))
			SwLog.getLogger()
			     .emitError(
					     SwNonCompliantValuesException.class,
					     "You cannot use the Java2D OpenGL inconjunction with the custom OpenGL wrapper. Make sure you are not calling useGL() and useGLHeavy() together!"
			     );
		else
			launchFlags.put(
					"swiggie.useHeavyGL",
					"true"
			);
		return this;
	}

	/**
	 * Whether Swiggie is using a logging framework for debugging purposes
	 * @return Whether Swiggie is using a logging framework for debugging purposes
	 */
	public boolean isSwiggieLogging()
	{
		return Boolean.parseBoolean((String) launchFlags.get("swiggie.useSwiggieLogging"));
	}

	/**
	 * Applies all launch flags to the JVM and the Swiggie framework
	 * @return The Swiggie instance
	 */
	public Swiggie arm()
	{
		launchFlags.forEach((k, v) -> System.setProperty(
				k,
				v.toString()
		));
		return this;
	}

}
