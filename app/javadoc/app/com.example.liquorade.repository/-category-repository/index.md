[app](../../index.md) / [com.example.liquorade.repository](../index.md) / [CategoryRepository](./index.md)

# CategoryRepository

`class CategoryRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CategoryRepository(service: `[`CocktailApiService`](../../com.example.liquorade.network/-cocktail-api-service/index.md)`, categoryDao: `[`CategoryDatabaseDao`](../../com.example.liquorade.database/-category-database-dao/index.md)`, connectionChecker: `[`ConnectionChecker`](../../com.example.liquorade.network/-connection-checker/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [categories](categories.md) | `val categories: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [getCategories](get-categories.md) | `suspend fun getCategories(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Category`](../../com.example.liquorade.domain/-category/index.md)`>`<br>Gets a list of categories from the back-end or from the local database, depending on the internet status Unnecessary categories are filtered out of the back-end |
