package pkg.exoad.swiggie

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SwTopLayerComponent(val layerName:String="DesktopLayer")

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SwLayeredComponent(val layerName:String="UnderlyingComponent")

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class SwInternalCall()