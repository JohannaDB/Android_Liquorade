[app](../../index.md) / [com.example.liquorade.di](../index.md) / [ApplicationComponent](./index.md)

# ApplicationComponent

`@Component([ApplicationModule, Subcomponents, NetworkModule]) interface ApplicationComponent`

### Types

| Name | Summary |
|---|---|
| [Factory](-factory/index.md) | `interface Factory` |

### Functions

| Name | Summary |
|---|---|
| [categoryComponent](category-component.md) | `abstract fun categoryComponent(): `[`Factory`](../../com.example.liquorade.category.di/-category-component/-factory/index.md) |
| [cocktailComponent](cocktail-component.md) | `abstract fun cocktailComponent(): `[`Factory`](../../com.example.liquorade.cocktail.di/-cocktail-component/-factory/index.md) |
| [cocktailDetailComponent](cocktail-detail-component.md) | `abstract fun cocktailDetailComponent(): `[`Factory`](../../com.example.liquorade.cocktaildetail.di/-cocktail-detail-component/-factory/index.md) |
| [ingredientDetailComponent](ingredient-detail-component.md) | `abstract fun ingredientDetailComponent(): `[`Factory`](../../com.example.liquorade.ingredientdetail.di/-ingredient-detail-component/-factory/index.md) |
| [randomCocktailComponent](random-cocktail-component.md) | `abstract fun randomCocktailComponent(): `[`Factory`](../../com.example.liquorade.randomcocktail.di/-random-cocktail-component/-factory/index.md) |
