package pkg.exoad.swiggie.intf;

import java.util.Optional;

public interface SwEventPayload<T, A>
{
	T oldEvent();

	T newEvent();

	Optional<A> source();
}
