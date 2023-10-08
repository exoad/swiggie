package pkg.exoad.swiggie.stx



class SwWrapper<T> private constructor(var value:T)
{
	fun value():T
	{
		return value
	}
	
	fun value(value:T)
	{
		this.value=value
	}
	companion object
	{
		@JvmStatic
		fun <T> acquire(value:T):SwWrapper<T>
		{
			return SwWrapper(value)
		}
	}
}

