package it.marioreina.demoviews

import android.app.Application
import it.marioreina.demoviews.di.getPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationImpl : Application() {

    override fun onCreate() {
        super.onCreate()

        /*if (BuildConfig.DEBUG) {
            AppLogger.init(applicationContext)
        }*/

        startKoin {
//            androidLogger(Level.NONE)
            androidContext(this@ApplicationImpl)
            modules(getPresentationModule())
        }
    }
}