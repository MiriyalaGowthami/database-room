plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt") // Required for Room annotation processing
}

android {
    namespace = "com.example.databaseroom" // <-- Add this line (your app package name)
    compileSdk = 34 // Set your target SDK version

    defaultConfig {
        applicationId = "com.example.databaseroom"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Room Database dependencies
    implementation("androidx.room:room-runtime:2.6.1") // Room 2.6.1 (latest version)
    kapt("androidx.room:room-compiler:2.6.1") // Room annotation processor
    implementation("androidx.room:room-ktx:2.6.1") // Kotlin extensions for Room

    // Lifecycle and ViewModel dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0") // viewModelScope support
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")

    // Kotlin Coroutines dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
