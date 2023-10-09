package pkg.exoad.swiggie.stx

import pkg.exoad.swiggie.intf.SwSwappable
import pkg.exoad.swiggie.tools.defs.SwUnsafe
import java.lang.ref.WeakReference

class SwPair<A:Any , B> private constructor(private var first:A , private var second:B):SwSwappable
{
	fun first():A
	{
		return first
	}
	
	fun second():B
	{
		return second
	}
	
	fun first(first:A)
	{
		this.first=first
	}
	
	fun second(second:B)
	{
		this.second=second
	}
	
	@SwUnsafe(reason="Unable to perform runtime type checking for generics on a Pair!")
	@Suppress("UNCHECKED_CAST")
	override fun swap()
	{
		val temp:Any=first
		first=second as A
		second=temp as B
	}
	
	companion object
	{
		fun <A:Any , B> acquire(first:A , second:B):SwPair<A , B>
		{
			return SwPair(first , second)
		}
		
		fun <A:Any , B> acquireWeak(first:A , second:B):WeakReference<SwPair<A , B>>
		{
			return WeakReference(SwPair(first , second))
		}
	}
}
