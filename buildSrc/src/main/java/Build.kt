object Build {
    private const val androidBuildToolsVersion = "7.0.4"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    private const val hiltAndroidGradlePluginVersion = "2.38.1"
    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"

    private const val ktlintAndroidGradlePluginVersion = "10.2.1"
    const val ktlintAndroidGradlePlugin =
        "org.jlleitschuh.gradle:ktlint-gradle:$ktlintAndroidGradlePluginVersion"

    private const val detektAndroidGradlePluginVersion = "1.17.0"
    const val detektAndroidGradlePlugin =
        "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektAndroidGradlePluginVersion"
}