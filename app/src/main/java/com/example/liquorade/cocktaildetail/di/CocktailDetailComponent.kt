package com.example.liquorade.cocktaildetail.di

import com.example.liquorade.cocktaildetail.CocktailDetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [CocktailDetailModule::class])
interface CocktailDetailComponent {
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates the component
         *
         * @return CocktailDetailComponent
         */
        fun create(): CocktailDetailComponent
    }

    /**
     * Allows Dagger2 to inject into this fragment
     *
     * @param fragment The CocktailDetailFragment
     */
    fun inject(fragment: CocktailDetailFragment)
}
