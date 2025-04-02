plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.siktv"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.siktv"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // تمكين ViewBinding بشكل صحيح
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation ("com.google.android.exoplayer:exoplayer:2.15.1")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.google.android.exoplayer:exoplayer:2.18.5")
    implementation ("com.google.android.exoplayer:exoplayer-ui:2.18.5")
    implementation("com.google.android.exoplayer:exoplayer:2.19.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
    implementation("com.google.android.material:material:1.11.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Testing dependencies
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
