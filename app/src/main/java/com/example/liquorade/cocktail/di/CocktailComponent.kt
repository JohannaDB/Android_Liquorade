package com.example.liquorade.cocktail.di

import com.example.liquorade.cocktail.CocktailFragment
import dagger.Subcomponent

@Subcomponent(modules = [CocktailModule::class])
interface CocktailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CocktailComponent
    }

    fun inject(fragment: CocktailFragment)
}