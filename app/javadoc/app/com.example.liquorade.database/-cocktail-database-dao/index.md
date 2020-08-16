[app](../../index.md) / [com.example.liquorade.database](../index.md) / [CocktailDatabaseDao](./index.md)

# CocktailDatabaseDao

`interface CocktailDatabaseDao`

### Functions

| Name | Summary |
|---|---|
| [getCocktails](get-cocktails.md) | `abstract fun getCocktails(categoryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CocktailDb`](../-cocktail-db/index.md)`>`<br>Returns all cocktails from a specific category stored in the database |
| [insert](insert.md) | `abstract fun insert(cocktails: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CocktailDb`](../-cocktail-db/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Inserts a list of cocktails into the database |
