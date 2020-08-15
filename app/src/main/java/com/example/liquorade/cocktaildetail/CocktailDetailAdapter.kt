package com.example.liquorade.cocktaildetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.liquorade.databinding.IngredientListItemBinding

class CocktailDetailAdapter(context: Context, ingredientList: Int, objects: List<Map.Entry<String?, String?>>) : ArrayAdapter<Map.Entry<String?, String?>>(context, ingredientList, objects) {
    val allItems = objects
    /**
     * Get a View that displays the data at the specified position in the data set
     *
     * @param position The position of the item
     * @param convertView The old view to reuse, if possible
     * @param parent The parent this view will be attached to
     * @return View corresponding to the data at the specified position
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding = IngredientListItemBinding.inflate(LayoutInflater.from(context))
        val ingredient = getItem(position)
        if (ingredient != null) {
            binding.ingredientListItemIngredient.setText(ingredient?.key)
            binding.ingredientListItemMeasurement.setText(ingredient?.value)
        }
        return binding.root
    }

    /**
     * Gets the amount of items in the data set
     * Minus 1 when the list is not null, because the last item is always null
     *
     * @return Count of items
     */
    override fun getCount(): Int {
        return if (allItems[allItems.size - 1].key != null) allItems.size else allItems.size - 1
    }
}
