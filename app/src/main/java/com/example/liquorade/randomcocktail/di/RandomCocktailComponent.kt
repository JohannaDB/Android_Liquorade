package com.example.liquorade.randomcocktail.di

import com.example.liquorade.randomcocktail.RandomCocktailFragment
import dagger.Subcomponent

@Subcomponent(modules = [RandomCocktailModule::class])
interface RandomCocktailComponent {
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates the component
         *
         * @return RandomCocktailComponent
         */
        fun create(): RandomCocktailComponent
    }

    /**
     * Allows Dagger2 to inject into this fragment
     *
     * @param fragment The RandomCocktailFragment
     */
    fun inject(fragment: RandomCocktailFragment)
}
