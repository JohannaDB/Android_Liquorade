package com.example.liquorade

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.liquorade.category.CategoryAdapter
import com.example.liquorade.cocktail.CocktailAdapter
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.Cocktail
import kotlinx.android.synthetic.main.fragment_random_cocktail.view.*

@BindingAdapter("listData")
        /**
         * Binds the list of cocktails to the RecyclerView
         *
         * @param recyclerView The RecyclerView
         * @param data List of cocktails
         */
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Cocktail>?) {
    val adapter = recyclerView.adapter as CocktailAdapter
    adapter.submitList(data)
}

@BindingAdapter("listCategoryData")
        /**
         * Binds the list of categories to the RecyclerView
         *
         * @param recyclerView The RecyclerView
         * @param data List of categories
         */
fun bindRecyclerViewCategory(recyclerView: RecyclerView, data: List<Category>?) {
    val adapter = recyclerView.adapter as CategoryAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
        /**
         * Uses the Glide library to load an image by URL into an [ImageView]
         *
         * @param imgView The ImageView
         * @param imgUrl The image url
         */
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("imageUrlRounded")
        /**
         * Uses the Glide library to load an image by URL into an [ImageView], rounds the image
         *
         * @param imgView The ImageView
         * @param imgUrl The image url
         */
fun bindImageRounded(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .transform(RoundedCorners(50))
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("cocktailApiStatus")
        /**
         * Binds the api status
         *
         * @param statusImageView The ImageView
         * @param status The api status
         */
fun bindStatus(statusImageView: View, status: CocktailApiStatus?) {
    when (status) {
        CocktailApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.status_image.setImageResource(R.drawable.loading_animation)
        }
        CocktailApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.status_image.setImageResource(R.drawable.ic_connection_error)
            statusImageView.status_text.setText(R.string.no_internet)
        }
        CocktailApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}