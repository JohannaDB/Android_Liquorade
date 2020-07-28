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
        fun bind(cocktail: Cocktail) {
            binding.cocktail = cocktail
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.idDrink == newItem.idDrink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailAdapter.CocktailViewHolder {
        return CocktailViewHolder(CocktailListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CocktailAdapter.CocktailViewHolder, position: Int) {
        val cocktail = getItem(position)
        holder.itemView.setOnClickListener { click.onClick(getItem(position).idDrink) }
        holder.bind(cocktail)
    }
}