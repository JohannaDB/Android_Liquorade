[app](../../index.md) / [com.example.liquorade.cocktail.di](../index.md) / [CocktailModule](index.md) / [provideRepository](./provide-repository.md)

# provideRepository

`@Provides fun provideRepository(database: `[`CocktailDatabase`](../../com.example.liquorade.database/-cocktail-database/index.md)`, service: `[`CocktailApiService`](../../com.example.liquorade.network/-cocktail-api-service/index.md)`, connectionChecker: `[`ConnectionChecker`](../../com.example.liquorade.network/-connection-checker/index.md)`): `[`CocktailRepository`](../../com.example.liquorade.repository/-cocktail-repository/index.md)

Explains how the CocktailRepository is created

### Parameters

`database` - The CocktailDatabase

`service` - The CocktailApiService

`connectionChecker` - The ConnectionChecker

**Return**
The CocktailRepository

