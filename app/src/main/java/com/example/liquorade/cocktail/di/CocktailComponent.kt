package com.example.liquorade.cocktail.di

import com.example.liquorade.cocktail.CocktailFragment
import dagger.Subcomponent

@Subcomponent(modules = [CocktailModule::class])
interface CocktailComponent {
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates the component
         *
         * @return CocktailComponent
         */
        fun create(): CocktailComponent
    }

    /**
     * Allows Dagger2 to inject into this fragment
     *
     * @param fragment The CocktailFragment
     */
    fun inject(fragment: CocktailFragment)
}
