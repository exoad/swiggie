package pkg.exoad.swiggie;

import lombok.NonNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class SwAssets
{
	public enum CacheStrength
	{
		WEAK,
		STRONG
	}

	private static SwAssets assets;

	public static SwAssets acquire()
	{
		if (assets == null)
			assets = acquire(CacheStrength.WEAK);
		return assets;
	}

	public static SwAssets acquire(@NonNull CacheStrength strength)
	{
		return new SwAssets(strength);
	}

	private final Map<String, Object> resourceCache;

	private SwAssets(CacheStrength strength)
	{
		resourceCache = strength == CacheStrength.STRONG ? new HashMap<>() : new WeakHashMap<>();
	}

	public File fetchFile(String path)
	{
		if (resourceCache.containsKey(path))
			return (File) resourceCache.get(path);
		File i;
		try
		{
			i = new File(Objects.requireNonNull(getClass().getResource(path)
			                                              .getFile()));
		} catch (NullPointerException e)
		{
			i = new File(path);
		}
		resourceCache.put(
				path,
				i
		);
		return i;
	}

}
