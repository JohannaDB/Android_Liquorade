package com.example.liquorade.category.di

import com.example.liquorade.category.CategoryFragment
import dagger.Subcomponent

@Subcomponent(modules = [CategoryModule::class])
interface CategoryComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CategoryComponent
    }

    fun inject(fragment: CategoryFragment)
}