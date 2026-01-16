plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

//plugins {
////    alias(libs.plugins.android.application version)
////    alias(libs.plugins.jetbrains.kotlin.android)
//    id("com.android.application") version "8.6.1"
//    id("org.jetbrains.kotlin.android") version "2.3.0"
//}

android {
    namespace = "com.example.llama"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.llama.aichat"

        minSdk = 31
        targetSdk = 34

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
        // 添加以下行
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.ExperimentalStdlibApi",
            // 如果还有其他实验性API，也可以在这里添加
        )
    }
}
//// 在 app/build.gradle.kts 的 dependencies 前添加
//configurations.all {
//    resolutionStrategy {
//        // 强制使用兼容 compileSdk 31 的版本
//        force("androidx.core:core-ktx:1.12.0")
//        force("androidx.core:core:1.12.0")
//        force("androidx.activity:activity:1.8.0")
//        force("androidx.appcompat:appcompat:1.6.1")
//    }
//}
dependencies {
    implementation(libs.bundles.androidx)
    implementation(libs.material)

    implementation(project(":lib"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.kotlinx.coroutines.android)

}
