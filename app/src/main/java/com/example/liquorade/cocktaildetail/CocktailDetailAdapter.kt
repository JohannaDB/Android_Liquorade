package com.example.liquorade.cocktaildetail

import android.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import com.example.liquorade.databinding.IngredientListItemBinding


class CocktailDetailAdapter(context: Context, ingredientList: Int, objects: List<Map.Entry<String?, String?>>) : ArrayAdapter<Map.Entry<String?, String?>>(context, ingredientList, objects) {
    val allItems = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding = IngredientListItemBinding.inflate(LayoutInflater.from(context))
        val ingredient = getItem(position)
        if(ingredient != null) {
            binding.ingredientText.setText(ingredient?.key)
            binding.measurementText.setText(ingredient?.value)
        }
        return binding.root
    }

    override fun getCount(): Int {
        return if (allItems[allItems.size - 1].key != null) allItems.size else allItems.size - 1
    }
}