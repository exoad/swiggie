package pkg.exoad.swiggie.intf;

import java.util.function.Function;

public interface Then<T>
{
	< R > Then<R> then(Function<T, R> fx);
}
