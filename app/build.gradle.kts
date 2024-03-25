import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

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
        versionName = Configuration.versionName

        buildConfigField("String", "API_KEY", getApiKey("API_KEY"))

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
    implementation(project(":core-data"))
    implementation(Libraries.androidx_core)
    implementation(Libraries.androidx_appcompat)
    implementation(Libraries.material)
    implementation(Libraries.timber)

    implementation(Libraries.navigation_ktx)
    implementation(Libraries.navigation_ui_ktx)
    implementation(Libraries.navigation_dynamic_feature)
    implementation(Libraries.coil)
    implementation(Libraries.hilt_plugin)
    implementation(Libraries.hilt_android)
    implementation(Libraries.hilt_inject)
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}