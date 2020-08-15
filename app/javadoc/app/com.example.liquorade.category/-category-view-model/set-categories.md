[app](../../index.md) / [com.example.liquorade.category](../index.md) / [CategoryViewModel](index.md) / [setCategories](./set-categories.md)

# setCategories

`fun setCategories(categories: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Category`](../../com.example.liquorade.domain/-category/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the categoryList to the given list of categories
If the list is empty, the api status is set to ERROR, otherwise to DONE

### Parameters

`categories` - List of categories