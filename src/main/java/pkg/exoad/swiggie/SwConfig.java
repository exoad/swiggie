package pkg.exoad.swiggie;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SwConfig
{
	private HashMap<String, Object> _properties;

	private SwConfig(@NotNull HashMap<String, Object> optionalProperties)
	{
		_properties = optionalProperties;
	}

	private SwConfig()
	{
		this(new HashMap<>());
	}

}
