[app](../../index.md) / [com.example.liquorade.category.di](../index.md) / [CategoryModule](./index.md)

# CategoryModule

`@Module class CategoryModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CategoryModule()` |

### Functions

| Name | Summary |
|---|---|
| [provideRepository](provide-repository.md) | `fun provideRepository(database: `[`CocktailDatabase`](../../com.example.liquorade.database/-cocktail-database/index.md)`, service: `[`CocktailApiService`](../../com.example.liquorade.network/-cocktail-api-service/index.md)`, connectionChecker: `[`ConnectionChecker`](../../com.example.liquorade.network/-connection-checker/index.md)`): `[`CategoryRepository`](../../com.example.liquorade.repository/-category-repository/index.md)<br>Explains how the CategoryRepository is created |
| [provideViewModelFactory](provide-view-model-factory.md) | `fun provideViewModelFactory(repository: `[`CategoryRepository`](../../com.example.liquorade.repository/-category-repository/index.md)`): `[`CategoryViewModelFactory`](../../com.example.liquorade.category/-category-view-model-factory/index.md)<br>Explains how the CategoryViewModelFactory is created |
