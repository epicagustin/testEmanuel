package com.emanuel.testsessionemanuel.base

import android.app.Application
import com.emanuel.di.coreModule
import com.emanuel.di.remoteModule
import com.emanuel.di.repositoryModule
import com.emanuel.di.usecaseModule
import com.emanuel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

//@HiltAndroidApp
class TestEmanuelApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TestEmanuelApplication)
            modules(
                listOf(
                    usecaseModule,
                    coreModule,
                    remoteModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}