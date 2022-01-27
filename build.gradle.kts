// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.ktlintAndroidGradlePlugin)
        classpath(Build.detektAndroidGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

apply("buildscripts/git-hooks.gradle")
apply("buildscripts/ktlint.gradle")
apply("buildscripts/detekt.gradle")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// afterEvaluate {
//    tasks["clean"].dependsOn installGitHooks
// }
