import java.util.*
import java.io.FileInputStream

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id ("kotlin-parcelize")
    id ("maven-publish")
}

android {
    compileSdk = Setup.App.compileSdk
    buildToolsVersion = Setup.App.buildToolsVersion

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
//        applicationId = Setup.App.applicationId
        minSdk = Setup.App.minSdk
        targetSdk = Setup.App.targetSdk
        versionCode = Setup.App.versionCode
        versionName = Setup.App.versionName

        testInstrumentationRunner = Setup.App.testInstrumentationRunner
    }

    val keystoreProperties = Properties().apply {
        load(
            FileInputStream(file("keystore.properties"))
        )
    }

    signingConfigs {
        listOf("develop", "staging", "production").forEach { name ->
            create(name) {
                storeFile = file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
                keyAlias = keystoreProperties["${name}.keyAlias"] as String
                keyPassword = keystoreProperties["${name}.keyPassword"] as String
            }
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            isUseProguard = false
            signingConfig = null
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = false
            isUseProguard = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

//    flavorDimensions("default")
//
//    productFlavors {
//        create("develop") {
//            dimension("default")
////            versionNameSuffix = "-dev"
////            applicationIdSuffix = ".dev"
//            resValue("string", "app_name", "Base app")
//            buildConfigField("String", "BASE_API_URL", "\"${Setup.BaseApi.dev}\"")
//        }
//        create("staging") {
//            dimension("default")
////            versionNameSuffix = "-stg"
////            applicationIdSuffix = ".stg"
//            resValue("string", "app_name", "Base app")
//            buildConfigField("String", "BASE_API_URL", "\"${Setup.BaseApi.staging}\"")
//        }
//        create("production") {
//            dimension("default")
//            resValue("string", "app_name", "Base App")
//            buildConfigField("String", "BASE_API_URL", "\"${Setup.BaseApi.production}\"")
//        }
//    }
//
//    productFlavors.forEach {
//        it.signingConfig = signingConfigs.getByName(it.name)
//    }

    compileOptions {
        sourceCompatibility = Setup.App.sourceCompatibility
        targetCompatibility = Setup.App.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        exclude("project.properties")
        exclude("META-INF/DEPENDENCIES")
    }
}

dependencies {
    implementation(Dependencies.JetBrains.kotlinStdlib)
    testImplementation(Dependencies.Junit.junit)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.junit)
    implementation(Dependencies.AndroidX.espressoCore)
    implementation(Dependencies.AndroidX.fragmentKtx)
    implementation(Dependencies.AndroidX.lifecycleViewModelKtx)
    implementation(Dependencies.AndroidX.lifecycleLiveDataKtx)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    implementation(Dependencies.AndroidX.lifecycleCommonKtx)
    implementation(Dependencies.AndroidX.navigationFragmentKtx)
    implementation(Dependencies.AndroidX.navigationUiKtx)
    implementation(Dependencies.JakeWharton.timber)
    implementation(Dependencies.Google.hiltAndroid)
    kapt(Dependencies.Google.hiltCompiler)
    implementation(Dependencies.JetBrains.kotlinXCoroutinesCore)
    implementation(Dependencies.JetBrains.kotlinXCoroutinesAndroid)
    implementation(Dependencies.SquareUp.loggingInterceptor)
    implementation(Dependencies.SquareUp.retrofit)
    implementation(Dependencies.SquareUp.converterGson)
    implementation(Dependencies.AndroidX.hiltNavigationFragment)
    implementation(Dependencies.coil)
    implementation(Dependencies.AndroidX.roomRuntime)
    implementation(Dependencies.AndroidX.roomKtx)
    kapt(Dependencies.AndroidX.roomCompiler)
    implementation(Dependencies.ahBottomNavigation)
    implementation(Dependencies.AndroidX.recyclerview)
    implementation(Dependencies.balloon)
    implementation("com.github.jitpack:gradle-simple:1.0")
}