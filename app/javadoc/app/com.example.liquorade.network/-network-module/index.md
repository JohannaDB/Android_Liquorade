[app](../../index.md) / [com.example.liquorade.network](../index.md) / [NetworkModule](./index.md)

# NetworkModule

`@Module class NetworkModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkModule()` |

### Functions

| Name | Summary |
|---|---|
| [provideHttpClient](provide-http-client.md) | `fun provideHttpClient(): OkHttpClient`<br>Explains how the HttpClient is created |
| [provideMoshi](provide-moshi.md) | `fun provideMoshi(): Moshi`<br>Explains how Moshi is created, Moshi makes it easy to parse JSON to data objects |
| [provideRetrofit](provide-retrofit.md) | `fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit`<br>Explains how Retrofit is created |
| [provideService](provide-service.md) | `fun provideService(retrofit: Retrofit): `[`CocktailApiService`](../-cocktail-api-service/index.md)<br>Explains how the CocktailApiService is created |
