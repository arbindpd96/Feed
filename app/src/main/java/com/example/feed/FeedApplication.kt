package com.example.feed

import android.app.Application
import com.example.feed.networking.networkModule
import com.example.feed.networking.responseHandlerModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory

class FeedApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FeedApplication)
            fragmentFactory()
            modules(networkModule, repositoryModule, landingActivityViewModelModule, responseHandlerModule)
        }
    }
}