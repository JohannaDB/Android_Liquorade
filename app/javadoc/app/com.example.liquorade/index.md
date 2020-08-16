[app](../index.md) / [com.example.liquorade](./index.md)

## Package com.example.liquorade

### Types

| Name | Summary |
|---|---|
| [LiquoradeApplication](-liquorade-application/index.md) | `class LiquoradeApplication : `[`Application`](https://developer.android.com/reference/android/app/Application.html) |
| [MainActivity](-main-activity/index.md) | `class MainActivity : AppCompatActivity` |

### Functions

| Name | Summary |
|---|---|
| [bindImage](bind-image.md) | `fun bindImage(imgView: `[`ImageView`](https://developer.android.com/reference/android/widget/ImageView.html)`, imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Uses the Glide library to load an image by URL into an [ImageView](https://developer.android.com/reference/android/widget/ImageView.html) |
| [bindImageRounded](bind-image-rounded.md) | `fun bindImageRounded(imgView: `[`ImageView`](https://developer.android.com/reference/android/widget/ImageView.html)`, imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Uses the Glide library to load an image by URL into an [ImageView](https://developer.android.com/reference/android/widget/ImageView.html), rounds the image |
| [bindIngredientInfo](bind-ingredient-info.md) | `fun bindIngredientInfo(buttonText: `[`Button`](https://developer.android.com/reference/android/widget/Button.html)`, ingredientName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [bindRecyclerView](bind-recycler-view.md) | `fun bindRecyclerView(recyclerView: RecyclerView, data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../com.example.liquorade.domain/-cocktail/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds the list of cocktails to the RecyclerView |
| [bindRecyclerViewCategory](bind-recycler-view-category.md) | `fun bindRecyclerViewCategory(recyclerView: RecyclerView, data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Category`](../com.example.liquorade.domain/-category/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds the list of categories to the RecyclerView |
| [bindStatus](bind-status.md) | `fun bindStatus(statusImageView: `[`View`](https://developer.android.com/reference/android/view/View.html)`, status: `[`CocktailApiStatus`](../com.example.liquorade.cocktail/-cocktail-api-status/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds the api status |
