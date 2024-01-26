// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
        // other repositories if needed
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4") // existing Android Gradle Plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // existing Kotlin Gradle Plugin
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6") // add this line for Safe Args

        // other classpath dependencies
    }
}

plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

// Rest of your project-level build.gradle file
