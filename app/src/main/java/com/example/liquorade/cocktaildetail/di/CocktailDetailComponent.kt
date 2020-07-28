package com.example.liquorade.cocktaildetail.di

import com.example.liquorade.cocktaildetail.CocktailDetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [CocktailDetailModule::class])
interface CocktailDetailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CocktailDetailComponent
    }

    fun inject(fragment: CocktailDetailFragment)
}