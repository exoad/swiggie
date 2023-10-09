package pkg.exoad.swiggie.tools.defs

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SwTopLayerComponent(val layerName:String="DesktopLayer")

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SwLayeredComponent(val layerName:String="UnderlyingComponent")

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.SOURCE)
annotation class SwUnsafe(val reason:String = "")
