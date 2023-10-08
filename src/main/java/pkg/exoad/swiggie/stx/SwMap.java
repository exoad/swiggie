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

	public void onKeyExistAndOrElse(K key, SwCallback<Boolean, V> condition, SwVoidCallback<V> consumer)
	{
		onKeyExist(key, e -> {
			if (condition.call(e))
				consumer.call(e);
		});
	}

	public Optional<V> onKeyEmpty(K key)
	{
		if (containsKey(key))
			return Optional.of(get(key));
		return Optional.empty();
	}
}
