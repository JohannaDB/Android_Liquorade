[app](../../index.md) / [com.example.liquorade.category](../index.md) / [CategoryViewModel](./index.md)

# CategoryViewModel

`class CategoryViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CategoryViewModel(categoryRepo: `[`CategoryRepository`](../../com.example.liquorade.repository/-category-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [categoryList](category-list.md) | `val categoryList: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Category`](../../com.example.liquorade.domain/-category/index.md)`>>` |
| [navigation](navigation.md) | `val navigation: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [status](status.md) | `val status: LiveData<`[`CocktailApiStatus`](../../com.example.liquorade.cocktail/-cocktail-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [displayCocktails](display-cocktails.md) | `fun displayCocktails(categoryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the navigation value to the name of selected category |
| [getCategories](get-categories.md) | `fun getCategories(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gets the list of categories from the Repository and sets the api status to LOADING and ERROR or DONE |
| [navigationComplete](navigation-complete.md) | `fun navigationComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method gets called when the navigation is completed |
