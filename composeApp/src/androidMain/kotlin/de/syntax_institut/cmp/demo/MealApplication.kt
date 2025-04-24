package de.syntax_institut.cmp.demo

import android.app.Application
import de.syntax_institut.cmp.demo.di.initKoin
import org.koin.android.ext.koin.androidContext

class MealApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MealApplication)
        }
    }
}

