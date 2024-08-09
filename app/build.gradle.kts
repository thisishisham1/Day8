plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.navigation.safe.args)
    alias(libs.plugins.ksp)
}

android {
    namespace =
        "klivvr.test.day8" // Consider a more descriptive package name, e.g., com.yourcompany.yourapp
    compileSdk = 34

    defaultConfig {
        applicationId = "klivvr.test.day8" // Should match the namespace
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true // Enable minification for release builds to reduce app size
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Image loading
    implementation(libs.bumptech.glide)

    // Networking
    implementation(libs.square.retrofit)
    implementation(libs.square.converter.gson)
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.interceptor) // Consider using OkHttp's logging interceptor for debugging

    // Lifecycle& ViewModels
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
}