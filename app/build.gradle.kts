import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.openclassrooms.notes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.openclassrooms.notes"
        minSdk = 24
        targetSdk = 33
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "1.8"
        jvmTarget = "17"
    }
}

dependencies {
    val lifecycle_version = "2.7.0"
    val arch_version = "2.2.0"

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version") //viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version") //Viewmodel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version") //LiveData
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version") //saved state module for viewmodel
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version") //lifeCycle Only without View Midel or livedata
    implementation("com.google.dagger:hilt-android:2.51")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.activity:activity-ktx:1.3.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:$arch_version") // test helpers for livedata
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51")


}

fun kapt(options: String) {

}
