buildscript {
    repositories {
        // Make sure that you have the following two repositories
        google()  // Google's Maven repository
        mavenCentral()  // Maven Central repository
    }
    dependencies {
        // Add the dependency for the Google services Gradle plugin
        classpath ("com.google.gms:google-services:4.4.0")
    }
}

plugins {
    id("com.android.application") version "8.1.3" apply false
    id ("com.android.library") version "8.1.3" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}