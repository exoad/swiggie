package pkg.exoad.swiggie.dirt

@Target(AnnotationTarget.FUNCTION , AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.BINARY)
@Repeatable

/**
 * A generator annotation for the Dirt Runtime to use to analyze the typing of an
 * optional parameter in a function.
 *
 * @param name Used to represent this parameter's name
 * @param type Used to represent this parameter's type (strictly enforced)
 * @param defaultCall An injected call to replace as if this parameter is not used. Note this is not a value, this is syntax tree to replace as.
 */
annotation class SwOptionalParam(val name:String="UndefinedParam" , val type:String="UndefinedParamType" , val defaultCall:String)
