[app](../../index.md) / [com.example.liquorade.cocktail](../index.md) / [CocktailViewModel](./index.md)

# CocktailViewModel

`class CocktailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CocktailViewModel(cocktailRepo: `[`CocktailRepository`](../../com.example.liquorade.repository/-cocktail-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [category_Name](category_-name.md) | `val category_Name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [cocktailList](cocktail-list.md) | `val cocktailList: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../../com.example.liquorade.domain/-cocktail/index.md)`>>` |
| [navigation](navigation.md) | `val navigation: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [status](status.md) | `val status: LiveData<`[`CocktailApiStatus`](../-cocktail-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [displayCocktailDetails](display-cocktail-details.md) | `fun displayCocktailDetails(cocktailId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the navigation value to the id of selected cocktail |
| [getCocktails](get-cocktails.md) | `fun getCocktails(categoryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../../com.example.liquorade.domain/-cocktail/index.md)`>>`<br>Gets the list of cocktails from the Repository and sets the api status to LOADING |
| [navigationComplete](navigation-complete.md) | `fun navigationComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method gets called when the navigation is completed |
| [setCocktails](set-cocktails.md) | `fun setCocktails(cocktails: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../../com.example.liquorade.domain/-cocktail/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the cocktailList to the given list of cocktails If the list is empty, the api status is set to ERROR, otherwise to DONE |
