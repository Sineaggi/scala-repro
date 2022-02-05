plugins {
    id("org.gradle.playframework") version "0.12"
}

repositories {
    mavenCentral()
    maven("https://repo.lightbend.com/lightbend/maven-releases")
    maven("https://repo.typesafe.com/typesafe/maven-releases/")
}

play {
    platform {
        playVersion.set("2.3.10")
        scalaVersion.set("2.11.12")
        // If newer versions of zinc were available, we should be able to bump the java version to >1.8
        // follow https://github.com/gradle/gradle/issues/15491 for updates
        javaVersion.set(JavaVersion.VERSION_1_8)
    }
}

tasks.withType<ScalaCompile>().configureEach {
    // it is possible that the default, 1.8 has additional classfile verification.
    // by setting it to java 1.6, the jvm will load the class file.

    // disabling this breaks
    scalaCompileOptions.additionalParameters = listOf("-target:jvm-1.8")
}

dependencies {
    implementation("org.scala-lang:scala-compiler:2.11.12")
    implementation("org.scala-lang:scala-library:2.11.12")
    implementation("org.scala-lang:scala-reflect:2.11.12")
}
