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
        /**
         * Defines what the ViewHolder will bind to
         *
         * @param category The category item to pass through
         */
        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        /**
         * Method that checks if items are the same
         *
         * @param oldItem The old Category item
         * @param newItem The new Category item
         * @return Boolean saying if old and new item are the same or not
         */
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        /**
         * Method that checks if content of the items are the same
         *
         * @param oldItem The old Category item
         * @param newItem The new Category item
         * @return Boolean saying if old and new item have the same content or not
         */
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.strIngredient1 == newItem.strIngredient1
        }
    }

    /**
     * Creates the ViewHolder for the RecyclerView
     *
     * @param parent The parent ViewGroup
     * @param viewType The type of the view
     * @return New CategoryViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryViewHolder {
        return CategoryViewHolder(CategoryListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Method that updates the content of the RecyclerView
     * When a row (view) of the RecyclerView gets scrolled off the screen, the view gets recycled and new data is bound to the view
     *
     * @param holder The CategoryViewHolder
     * @param position The position of the CategoryViewHolder
     */
    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.itemView.setOnClickListener { click.onClick(getItem(position).strIngredient1) }
        holder.bind(category)
    }
}

class OnClickListener(val click: (categoryName: String) -> Unit) {
    fun onClick(categoryName: String) = click(categoryName)
}