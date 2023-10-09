plugins {
	id("java")
	kotlin("jvm") version "1.9.20-Beta2"
}

group="pkg.exoad"
version="1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains:annotations:24.0.0")
	testImplementation(platform("org.junit:junit-bom:5.9.1"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testImplementation("org.reflections:reflections:0.9.12")
	testRuntimeOnly("org.reflections:reflections:0.9.12")
	implementation(kotlin("stdlib-jdk8"))
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")
	testCompileOnly("org.projectlombok:lombok:1.18.30")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
	compileOnly("org.jogamp.gluegen:gluegen-rt:2.3.1")
	compileOnly("org.jogamp.jogl:jogl-all:2.3.1")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-android-aarch64")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-android-armv6")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-linux-amd64")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-linux-armv6")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-linux-armv6hf")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-linux-i586")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-macosx-universal")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-windows-amd64")
	runtimeOnly("org.jogamp.gluegen:gluegen-rt:2.3.1:natives-windows-i586")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-linux-amd64")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-linux-armv6")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-linux-armv6hf")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-linux-i586")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-macosx-universal")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-windows-amd64")
	runtimeOnly("org.jogamp.jogl:jogl-all:2.3.1:natives-windows-i586")
	runtimeOnly("com.formdev.flatlaf:flatlaf:3.2.1")
	runtimeOnly("com.formdev.flatlaf:flatlaf-intellij-themes:3.2.1")
}

tasks.test {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(17)
}