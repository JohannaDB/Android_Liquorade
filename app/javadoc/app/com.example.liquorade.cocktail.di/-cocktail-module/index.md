[app](../../index.md) / [com.example.liquorade.cocktail.di](../index.md) / [CocktailModule](./index.md)

# CocktailModule

`@Module class CocktailModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CocktailModule()` |

### Functions

| Name | Summary |
|---|---|
| [provideRepository](provide-repository.md) | `fun provideRepository(database: `[`CocktailDatabase`](../../com.example.liquorade.database/-cocktail-database/index.md)`, service: `[`CocktailApiService`](../../com.example.liquorade.network/-cocktail-api-service/index.md)`, connectionChecker: `[`ConnectionChecker`](../../com.example.liquorade.network/-connection-checker/index.md)`): `[`CocktailRepository`](../../com.example.liquorade.repository/-cocktail-repository/index.md)<br>Explains how the CocktailRepository is created |
| [provideViewModelFactory](provide-view-model-factory.md) | `fun provideViewModelFactory(repository: `[`CocktailRepository`](../../com.example.liquorade.repository/-cocktail-repository/index.md)`): `[`CocktailViewModelFactory`](../../com.example.liquorade.cocktail/-cocktail-view-model-factory/index.md)<br>Explains how the CocktailViewModelFactory is created |
