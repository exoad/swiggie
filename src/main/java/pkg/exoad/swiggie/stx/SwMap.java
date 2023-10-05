package pkg.exoad.swiggie.stx;

import java.util.HashMap;
import java.util.Optional;

public class SwMap<K, V>
		extends HashMap<K, V>
{
	public void onKeyExist(K key, SwVoidCallback<V> consumer)
	{
		if (containsKey(key))
			consumer.call(get(key));
	}

	public Optional<V> onKeyEmpty(K key)
	{
		if (containsKey(key))
			return Optional.of(get(key));
		return Optional.empty();
	}
}
