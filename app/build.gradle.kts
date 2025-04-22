plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
}

android {
    namespace = "br.com.mylister"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.mylister"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // -------------------------------------------------------------------------------------------
    // Core
    // -------------------------------------------------------------------------------------------
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    // -------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------
    // JUnit
    // -------------------------------------------------------------------------------------------
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    // -------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------
    // Compose
    // -------------------------------------------------------------------------------------------
    // Activity
    implementation("androidx.activity:activity-compose:1.10.1")
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.9")
    // BOM
    implementation(platform("androidx.compose:compose-bom:2024.09.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.09.00"))
    // UI
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui-text-google-fonts:1.7.8")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    // Material
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material3:material3")
    // -------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------
    // Room
    // -------------------------------------------------------------------------------------------
    implementation("androidx.room:room-runtime:2.7.0")
    ksp("androidx.room:room-compiler:2.7.0")
    // -------------------------------------------------------------------------------------------
}