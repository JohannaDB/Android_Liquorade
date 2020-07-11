package com.example.liquorade.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.liquorade.databinding.CategoryListItemBinding
import com.example.liquorade.domain.Category

class CategoryAdapter(private val click: OnClickListener) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(DiffCallback) {
    class CategoryViewHolder(private var binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.strIngredient1 == newItem.strIngredient1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryViewHolder {
        return CategoryViewHolder(CategoryListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.itemView.setOnClickListener { click.onClick(getItem(position).strIngredient1) }
        holder.bind(category)
    }
}

class OnClickListener(val click: (categoryName: String) -> Unit) {
    fun onClick(categoryName: String) = click(categoryName)
}