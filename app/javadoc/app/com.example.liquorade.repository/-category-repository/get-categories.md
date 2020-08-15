[app](../../index.md) / [com.example.liquorade.repository](../index.md) / [CategoryRepository](index.md) / [getCategories](./get-categories.md)

# getCategories

`fun getCategories(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Category`](../../com.example.liquorade.domain/-category/index.md)`>>`

Gets a list of categories from the back-end or from the local database, depending on the internet status
Unnecessary categories are filtered out of the back-end

**Return**
LiveData list of categories

