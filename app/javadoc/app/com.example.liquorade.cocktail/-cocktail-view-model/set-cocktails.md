[app](../../index.md) / [com.example.liquorade.cocktail](../index.md) / [CocktailViewModel](index.md) / [setCocktails](./set-cocktails.md)

# setCocktails

`fun setCocktails(cocktails: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Cocktail`](../../com.example.liquorade.domain/-cocktail/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the cocktailList to the given list of cocktails
If the list is empty, the api status is set to ERROR, otherwise to DONE

### Parameters

`cocktails` - List of cocktails