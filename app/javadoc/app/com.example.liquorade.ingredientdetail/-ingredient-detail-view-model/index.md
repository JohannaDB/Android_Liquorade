[app](../../index.md) / [com.example.liquorade.ingredientdetail](../index.md) / [IngredientDetailViewModel](./index.md)

# IngredientDetailViewModel

`class IngredientDetailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `IngredientDetailViewModel(ingredientRepo: `[`IngredientDetailRepository`](../../com.example.liquorade.repository/-ingredient-detail-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [ingredientDetail](ingredient-detail.md) | `val ingredientDetail: LiveData<`[`IngredientDetail`](../../com.example.liquorade.domain/-ingredient-detail/index.md)`>` |
| [ingredientName](ingredient-name.md) | `val ingredientName: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [status](status.md) | `val status: LiveData<`[`CocktailApiStatus`](../../com.example.liquorade.cocktail/-cocktail-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [getIngredientDetails](get-ingredient-details.md) | `fun getIngredientDetails(ingredientName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gets the ingredient details from the Repository and sets the ingredient name, ingredient details and api status |
