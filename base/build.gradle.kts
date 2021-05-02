plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id ("kotlin-parcelize")
}

android {
    compileSdk  = 30
    buildToolsVersion  = "30.0.3"

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        minSdk = Setup.App.minSdk
        targetSdk = Setup.App.targetSdk
        versionCode = Setup.App.versionCode
        versionName = Setup.App.versionName

        testInstrumentationRunner = Setup.App.testInstrumentationRunner
//        consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = false
            isUseProguard = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Setup.App.sourceCompatibility
        targetCompatibility = Setup.App.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.JetBrains.kotlinStdlib)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.constraintLayout)
    testImplementation(Dependencies.Junit.junit)
//    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    implementation("com.github.jitpack:gradle-simple:1.0")
    implementation("com.google.code.gson:gson:2.8.6")
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
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
//            release(MavenPublication) {
//                from components.release
//                groupId = 'com.github.jitpack'
//                artifactId = 'chien-base'
//                version = '1.0'
//            }
            create<MavenPublication>("release") {
                from(components.findByName("release"))
                groupId = "com.github.jitpack"
                artifactId = "chien-base"
                version = "1.0"
            }
        }
    }
}