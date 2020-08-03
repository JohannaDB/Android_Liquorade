package com.example.liquorade.ingredientdetail.di

import com.example.liquorade.ingredientdetail.IngredientDetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [IngredientDetailModule::class])
interface IngredientDetailComponent{
    @Subcomponent.Factory
    interface Factory {
        fun create(): IngredientDetailComponent
    }
    fun inject(fragment: IngredientDetailFragment)
}