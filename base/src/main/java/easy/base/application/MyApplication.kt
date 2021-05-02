package easy.base.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import easy.base.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        var application: MyApplication? = null
        fun getInstance() = application
    }
}