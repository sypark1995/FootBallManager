object Versions {
    const val kotlin = "1.9.22"
    const val agp = "7.2.1"
    const val ksp = "1.7.10-1.0.6"
    const val material = "1.11.0"
    const val sceneView = "0.9.0"
    const val appcompat = "1.6.1"
    const val androidxCore = "1.12.0"
    const val androidxFragment = "1.5.0"
    const val constraintLayout = "2.1.4"
    const val androidxNavigation = "2.5.0"
    const val androidxLifecycle = "2.5.0"
    const val androidxWork = "2.7.1"
    const val androidxRoom = "2.6.1"
    const val datastore = "1.0.0"
    const val preference = "1.1.0-alpha03"
    const val zxingEmbedded = "3.5.0"
    const val zxingCore = "3.3.0"
    const val timber = "4.7.1"
    const val firebaseBom = "32.2.2"
    const val firebaseMessaging = "23.2.1"
    const val firebaseAnalytics = "21.3.0"
    const val jackson = "2.9.7"
    const val nav = "2.7.7"
    const val coil = "2.2.2"
    const val hiltAndroid = "2.46"
    const val retrofit = "2.9.0"
    const val okHttp = "4.12.0"
    const val moshi = "1.15.0"
    const val coroutine = "1.6.4"
    const val gson = "2.10.1"
}

object Libraries {
    const val agp = "com.android.tools.build:gradle:${Versions.agp}"
    const val ksp = "com.google.devtools.ksp:symbol-processing-api:${Versions.ksp}"
    const val kotlin_gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val navigation_safeargsPlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidxNavigation}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val gson = "com.google.code.gson:${Versions.gson}"
    const val sceneview = "io.github.sceneview:arsceneview:${Versions.sceneView}"
    const val androidx_core = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val encrypt_preference = "androidx.security:security-crypto:${Versions.preference}"
    const val zxing_embedded = "com.journeyapps:zxing-android-embedded:${Versions.zxingEmbedded}"
    const val zxing_core = "com.google.zxing:core:${Versions.zxingCore}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val firebase_bom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebase_messaging =
        "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"
    const val firebase_analytics =
        "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"

    const val navigation_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val navigation_dynamic_feature =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
    const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"

    const val hilt_inject = "javax.inject:javax.inject:1"

    const val retrofit = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val coroutine_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutine_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val room = "androidx.room:room-ktx:${Versions.androidxRoom}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.androidxRoom}"

}

