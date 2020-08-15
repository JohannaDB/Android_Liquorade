[app](../../index.md) / [com.example.liquorade.repository](../index.md) / [CocktailRepository](index.md) / [getCocktails](./get-cocktails.md)

# getCocktails

`fun getCocktails(categoryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../../com.example.liquorade.domain/-cocktail/index.md)`>>`

Gets a list of cocktails from the back-end or from the local database, depending on the internet status

### Parameters

`categoryName` - is the specified category name of the cocktails

**Return**
LiveData list of cocktails

