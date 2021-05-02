package easy.app.base.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import easy.app.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    companion object {
        var application: MyApplication? = null
        fun getInstance() = application
    }
}