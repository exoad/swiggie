package pkg.exoad.swiggie.intf

interface SwAWTSupport<T, K>
{
	fun toAWT():T
	fun fromAWT(value:T):K
}
