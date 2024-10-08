import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
	kotlin("jvm") version "1.9.0"
	kotlin("plugin.serialization") version "1.9.0"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

	testImplementation("junit:junit:4.13.2")
	testImplementation(kotlin("test-junit"))
}

tasks.withType<Test> {
	testLogging {
		exceptionFormat = TestExceptionFormat.FULL
		events("passed", "failed", "skipped")
	}
}