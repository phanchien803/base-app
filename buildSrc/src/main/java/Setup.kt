import org.gradle.api.JavaVersion

object Setup {
    object App {
        const val compileSdk = 30
        const val buildToolsVersion = "30.0.2"
        const val applicationId = "easy.news"
        const val minSdk = 21
        const val targetSdk = 30
        const val versionCode = 1
        const val versionName = "1.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val sourceCompatibility = JavaVersion.VERSION_1_8
        val targetCompatibility = JavaVersion.VERSION_1_8
    }

    object BaseApi {
        const val dev = "https://dev.com.vn/"
        const val staging = "https://staging.com.vn/"
        const val production = "https://production.com.vn/"
    }
}