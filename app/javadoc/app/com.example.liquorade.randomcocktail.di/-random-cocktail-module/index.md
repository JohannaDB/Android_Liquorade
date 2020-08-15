[app](../../index.md) / [com.example.liquorade.randomcocktail.di](../index.md) / [RandomCocktailModule](./index.md)

# RandomCocktailModule

`@Module class RandomCocktailModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RandomCocktailModule()` |

### Functions

| Name | Summary |
|---|---|
| [provideRepository](provide-repository.md) | `fun provideRepository(service: `[`CocktailApiService`](../../com.example.liquorade.network/-cocktail-api-service/index.md)`): `[`RandomCocktailRepository`](../../com.example.liquorade.repository/-random-cocktail-repository/index.md)<br>Explains how the RandomCocktailRepository is created |
| [provideViewModelFactory](provide-view-model-factory.md) | `fun provideViewModelFactory(repository: `[`RandomCocktailRepository`](../../com.example.liquorade.repository/-random-cocktail-repository/index.md)`): `[`RandomCocktailViewModelFactory`](../../com.example.liquorade.randomcocktail/-random-cocktail-view-model-factory/index.md)<br>Explains how the RandomCocktailViewModelFactory is created |
