[app](../../index.md) / [com.example.liquorade.network](../index.md) / [CocktailApiService](./index.md)

# CocktailApiService

`interface CocktailApiService`

### Functions

| Name | Summary |
|---|---|
| [getCategories](get-categories.md) | `abstract suspend fun getCategories(): `[`CategoryList`](../../com.example.liquorade.domain/-category-list/index.md)<br>Returns all categories |
| [getCocktailDetails](get-cocktail-details.md) | `abstract suspend fun getCocktailDetails(cocktailId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CocktailDetail`](../../com.example.liquorade.domain/-cocktail-detail/index.md)<br>Returns cocktail details of a specific cocktail |
| [getCocktails](get-cocktails.md) | `abstract suspend fun getCocktails(categoryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CocktailList`](../../com.example.liquorade.domain/-cocktail-list/index.md)<br>Returns all cocktails of a specific category |
| [getIngredientDetails](get-ingredient-details.md) | `abstract suspend fun getIngredientDetails(ingredientName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`IngredientDetails`](../../com.example.liquorade.domain/-ingredient-details/index.md)<br>Returns ingredient details of a specific ingredient |
| [getRandomCocktail](get-random-cocktail.md) | `abstract suspend fun getRandomCocktail(): `[`CocktailDetail`](../../com.example.liquorade.domain/-cocktail-detail/index.md)<br>Returns cocktail details of a random cocktail |
