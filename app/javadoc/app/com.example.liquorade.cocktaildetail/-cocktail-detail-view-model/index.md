[app](../../index.md) / [com.example.liquorade.cocktaildetail](../index.md) / [CocktailDetailViewModel](./index.md)

# CocktailDetailViewModel

`class CocktailDetailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CocktailDetailViewModel(detailRepo: `[`CocktailDetailRepository`](../../com.example.liquorade.repository/-cocktail-detail-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [cocktailDetail](cocktail-detail.md) | `val cocktailDetail: LiveData<`[`CocktailDetail`](../../com.example.liquorade.domain/-cocktail-detail/index.md)`>` |
| [cocktailId](cocktail-id.md) | `val cocktailId: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [ingredients](ingredients.md) | `val ingredients: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>` |
| [status](status.md) | `val status: LiveData<`[`CocktailApiStatus`](../../com.example.liquorade.cocktail/-cocktail-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [getCocktailDetails](get-cocktail-details.md) | `fun getCocktailDetails(cocktailId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gets the cocktail details from the Repository and sets the cocktailId, cocktail details and api status |
