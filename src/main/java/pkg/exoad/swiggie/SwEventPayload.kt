package pkg.exoad.swiggie

import java.util.*

interface SwEventPayload<T , A>
{
	fun oldEvent():T
	fun newEvent():T
	fun source():Optional<A>?
}