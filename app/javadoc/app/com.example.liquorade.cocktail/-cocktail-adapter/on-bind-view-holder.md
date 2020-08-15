[app](../../index.md) / [com.example.liquorade.cocktail](../index.md) / [CocktailAdapter](index.md) / [onBindViewHolder](./on-bind-view-holder.md)

# onBindViewHolder

`fun onBindViewHolder(holder: `[`CocktailViewHolder`](-cocktail-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Method that updates the content of the RecyclerView
When a row (view) of the RecyclerView gets scrolled off the screen, the view gets recycled and new data is bound to the view

### Parameters

`holder` - The CocktailViewHolder

`position` - The position of the CocktailViewHolder