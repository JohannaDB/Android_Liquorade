[app](../../index.md) / [com.example.liquorade.repository](../index.md) / [CocktailRepository](./index.md)

# CocktailRepository

`class CocktailRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CocktailRepository(service: `[`CocktailApiService`](../../com.example.liquorade.network/-cocktail-api-service/index.md)`, cocktailDao: `[`CocktailDatabaseDao`](../../com.example.liquorade.database/-cocktail-database-dao/index.md)`, connectionChecker: `[`ConnectionChecker`](../../com.example.liquorade.network/-connection-checker/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [getCocktails](get-cocktails.md) | `fun getCocktails(categoryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../../com.example.liquorade.domain/-cocktail/index.md)`>>`<br>Gets a list of cocktails from the back-end or from the local database, depending on the internet status |
