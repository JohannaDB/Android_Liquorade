package com.example.liquorade.di

import android.content.Context
import com.example.liquorade.category.di.CategoryComponent
import com.example.liquorade.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(modules = [ApplicationModule::class, Subcomponents::class, NetworkModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
    fun categoryComponent(): CategoryComponent.Factory
}

@Module(subcomponents = [CategoryComponent::class])
object Subcomponents