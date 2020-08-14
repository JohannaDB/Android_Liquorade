package com.example.liquorade.ingredientdetail.di

import com.example.liquorade.ingredientdetail.IngredientDetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [IngredientDetailModule::class])
interface IngredientDetailComponent{
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates the component
         *
         * @return IngredientDetailComponent
         */
        fun create(): IngredientDetailComponent
    }

    /**
     * Allows Dagger2 to inject into this fragment
     *
     * @param fragment The IngredientDetailFragment
     */
    fun inject(fragment: IngredientDetailFragment)
}