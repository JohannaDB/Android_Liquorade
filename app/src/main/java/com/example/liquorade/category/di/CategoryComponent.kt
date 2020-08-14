package com.example.liquorade.category.di

import com.example.liquorade.category.CategoryFragment
import dagger.Subcomponent

@Subcomponent(modules = [CategoryModule::class])
interface CategoryComponent {
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates the component
         *
         * @return CategoryComponent
         */
        fun create(): CategoryComponent
    }

    /**
     * Allows Dagger2 to inject into this fragment
     *
     * @param fragment The CategoryFragment
     */
    fun inject(fragment: CategoryFragment)
}