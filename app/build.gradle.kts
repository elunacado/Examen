plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.examen"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.examen"
        minSdk = 27
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
    //Retrofit
    //Retrofit does not have a built-in support for Kotlin Coroutines, so we need to add the adapter for it.
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Glide
    //Glide is an image loading library for Android that supports fetching, decoding, and displaying video stills, images, and animated GIFs.
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation(libs.androidx.runtime.saved.instance.state)
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation("jp.wasabeef:glide-transformations:4.3.0")

    //Coroutines
    //Kotlin Coroutines is a library that helps you write asynchronous, non-blocking code in a more natural way.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    //Fragment
    //A Fragment represents a behavior or a portion of user interface in an Activity.
    implementation("androidx.fragment:fragment-ktx:1.5.7")

    //Activity
    //An Activity is a single, focused thing that the user can do.
    implementation("androidx.activity:activity-ktx:1.5.0")

    //Data Binding
    //Data binding is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    implementation("androidx.databinding:databinding-adapters:4.2.2")

    implementation("androidx.savedstate:savedstate-ktx:1.2.0")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}