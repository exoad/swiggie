package pkg.exoad.swiggie

/**
 * This class just holds generic information regarding the Swiggie Library
 *
 * @author exoad
 */
object Swiggie
{
	/**
	 * The rolling release number for the versioning system.
	 *
	 * @return The SwiggieLib rolling release number
	 */
	val version:Long
		get()=1L
	
	/**
	 * The actual date of the rolling date found from [Swiggie.version]. This is
	 * represented as YYYY_MM_dd
	 *
	 * @return The rolling date
	 */
	val versionDate:Long
		get()=20230930L
	
	var useSwiggieDebugging:Boolean=false
	
	var prelaunchFlags:HashMap<String , String> = HashMap()
	
	fun useGL():Swiggie
	{
		prelaunchFlags["sun.java2d.opengl"]="true"
		return this
	}
	
	fun useGLHeavy():Swiggie
	{
		prelaunchFlags["sun.java2d.opengl"]="True"
		return this
	}
	
	/**
	 * Function to call to make sure every prelaunch propery is set
	 */
	fun arm():Swiggie
	{
		prelaunchFlags.forEach { (t , u)->
			System.setProperty(t , u)
		}
		return this
	}
}
