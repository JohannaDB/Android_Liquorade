package com.example.liquorade.di

import android.content.Context
import com.example.liquorade.category.di.CategoryComponent
import com.example.liquorade.cocktail.di.CocktailComponent
import com.example.liquorade.cocktaildetail.di.CocktailDetailComponent
import com.example.liquorade.ingredientdetail.di.IngredientDetailComponent
import com.example.liquorade.network.NetworkModule
import com.example.liquorade.randomcocktail.di.RandomCocktailComponent
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
    fun ingredientDetailComponent(): IngredientDetailComponent.Factory
    fun randomCocktailComponent(): RandomCocktailComponent.Factory
}

@Module(subcomponents = [CategoryComponent::class, CocktailComponent::class, CocktailDetailComponent::class, IngredientDetailComponent::class, RandomCocktailComponent::class])
object Subcomponents