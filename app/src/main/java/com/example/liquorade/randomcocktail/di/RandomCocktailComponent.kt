package com.example.liquorade.randomcocktail.di

import com.example.liquorade.randomcocktail.RandomCocktailFragment
import dagger.Subcomponent

@Subcomponent(modules = [RandomCocktailModule::class])
interface RandomCocktailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): RandomCocktailComponent
    }
    fun inject(fragment: RandomCocktailFragment)
}