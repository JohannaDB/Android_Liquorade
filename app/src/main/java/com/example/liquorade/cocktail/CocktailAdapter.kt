package com.example.liquorade.cocktail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.liquorade.category.OnClickListener
import com.example.liquorade.databinding.CocktailListItemBinding
import com.example.liquorade.domain.Cocktail

class CocktailAdapter(private val click: OnClickListener) : ListAdapter<Cocktail, CocktailAdapter.CocktailViewHolder>(DiffCallback) {
    class CocktailViewHolder(private var binding: CocktailListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Defines what the ViewHolder will bind to
         *
         * @param cocktail The cocktail item to pass through
         */
        fun bind(cocktail: Cocktail) {
            binding.cocktail = cocktail
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Cocktail>() {
        /**
         * Method that checks if items are the same
         *
         * @param oldItem The old Cocktail item
         * @param newItem The new Cocktail item
         * @return Boolean saying if old and new item are the same or not
         */
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem === newItem
        }

        /**
         * Method that checks if content of the items are the same
         *
         * @param oldItem The old Cocktail item
         * @param newItem The new Cocktail item
         * @return Boolean saying if old and new item have the same content or not
         */
        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.idDrink == newItem.idDrink
        }
    }

    /**
     * Creates the ViewHolder for the RecyclerView
     *
     * @param parent The parent ViewGroup
     * @param viewType The type of the view
     * @return New CocktailViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailAdapter.CocktailViewHolder {
        return CocktailViewHolder(CocktailListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Method that updates the content of the RecyclerView
     * When a row (view) of the RecyclerView gets scrolled off the screen, the view gets recycled and new data is bound to the view
     *
     * @param holder The CocktailViewHolder
     * @param position The position of the CocktailViewHolder
     */
    override fun onBindViewHolder(holder: CocktailAdapter.CocktailViewHolder, position: Int) {
        val cocktail = getItem(position)
        holder.itemView.setOnClickListener { click.onClick(getItem(position).idDrink) }
        holder.bind(cocktail)
    }
}
