plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.storeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.storeapp"
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
    buildFeatures {
        viewBinding = true
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

    //Networking
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation ("com.google.code.gson:gson:2.9.0")
    //viewModel
    implementation ("android.arch.lifecycle:extensions:1.1.1")
    //Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
    //Material Design
    implementation ("com.google.android.material:material:1.9.0-alpha01")
    //Encrypted SharedPref
    implementation ("androidx.security:security-crypto-ktx:1.1.0-alpha04")
    //Pagination
    implementation ("androidx.paging:paging-common-ktx:3.1.1")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    //kapt ("com.github.bumptech.glide:compiler:4.12.0")
}
// Allow references to generated code

//kapt {
//    correctErrorTypes = true
//}