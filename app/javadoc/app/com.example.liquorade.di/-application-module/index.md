[app](../../index.md) / [com.example.liquorade.di](../index.md) / [ApplicationModule](./index.md)

# ApplicationModule

`@Module class ApplicationModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ApplicationModule()` |

### Functions

| Name | Summary |
|---|---|
| [provideConnectionChecker](provide-connection-checker.md) | `fun provideConnectionChecker(connectivityManager: `[`ConnectivityManager`](https://developer.android.com/reference/android/net/ConnectivityManager.html)`): `[`ConnectionChecker`](../../com.example.liquorade.network/-connection-checker/index.md)<br>Explains how the connectionChecker is created |
| [provideConnectivityManager](provide-connectivity-manager.md) | `fun provideConnectivityManager(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`ConnectivityManager`](https://developer.android.com/reference/android/net/ConnectivityManager.html)<br>Explains how the ConnectivityManager is created |
| [provideDatabase](provide-database.md) | `fun provideDatabase(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`CocktailDatabase`](../../com.example.liquorade.database/-cocktail-database/index.md)<br>Explains how the database should be created |
