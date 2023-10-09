package pkg.exoad.swiggie.intf

import java.util.*

interface SwEventPayload<T , A>
{
	fun oldEvent():T
	fun newEvent():T
	fun source():Optional<A>?
}