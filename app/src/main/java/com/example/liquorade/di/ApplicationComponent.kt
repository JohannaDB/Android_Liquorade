package com.example.liquorade.di

import android.content.Context
import com.example.liquorade.category.di.CategoryComponent
import com.example.liquorade.cocktail.di.CocktailComponent
import com.example.liquorade.cocktaildetail.di.CocktailDetailComponent
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
    fun cocktailComponent(): CocktailComponent.Factory
    fun cocktailDetailComponent(): CocktailDetailComponent.Factory
}

@Module(subcomponents = [CategoryComponent::class, CocktailComponent::class, CocktailDetailComponent::class])
object Subcomponents