plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.football.manager"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        applicationId = "com.football.manager"
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = Configuration.versionCode
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core-network"))
    implementation(Libraries.androidx_core)
    implementation(Libraries.androidx_appcompat)
    implementation(Libraries.material)
    implementation(Libraries.timber)

    implementation(Libraries.navigation_ktx)
    implementation(Libraries.navigation_ui_ktx)
    implementation(Libraries.navigation_dynamic_feature)
    implementation(Libraries.coil)
}