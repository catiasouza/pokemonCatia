package com.example.pokemoncatia

import android.app.Application
import com.example.pokemoncatia.di.networkModule
import com.example.pokemoncatia.di.repositoryModule
import com.example.pokemoncatia.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }

}