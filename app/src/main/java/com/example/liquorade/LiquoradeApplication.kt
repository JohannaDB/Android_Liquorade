package com.example.liquorade

import android.app.Application
import com.example.liquorade.di.ApplicationComponent
import com.example.liquorade.di.DaggerApplicationComponent

class LiquoradeApplication : Application() {
    val component: ApplicationComponent by lazy {
        createComponent()
    }

    fun createComponent(): ApplicationComponent {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}
