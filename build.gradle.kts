plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.navigation.safe.args) apply false
    id("com.google.devtools.ksp") version "1.8.0-1.0.9" apply false

}