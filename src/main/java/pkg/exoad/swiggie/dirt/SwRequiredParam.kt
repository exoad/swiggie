package pkg.exoad.swiggie.dirt

@Target(AnnotationTarget.FUNCTION , AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.BINARY)
@Repeatable

/**
 * Represents a parameter that must be supplied.
 *
 * This annotation is used for the Dirt VM in order to parse and be able to
 * interface with the JVM end of this library.
 *
 * @param name The parameter name
 * @param type The Dirt alternative to this simple type
 *
 */
annotation class SwRequiredParam(val name:String="UndefinedParam" , val type:String="UndefinedParamType")
