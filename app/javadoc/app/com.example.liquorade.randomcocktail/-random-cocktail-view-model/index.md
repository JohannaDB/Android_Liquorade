[app](../../index.md) / [com.example.liquorade.randomcocktail](../index.md) / [RandomCocktailViewModel](./index.md)

# RandomCocktailViewModel

`class RandomCocktailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RandomCocktailViewModel(repository: `[`RandomCocktailRepository`](../../com.example.liquorade.repository/-random-cocktail-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [randomCocktail](random-cocktail.md) | `val randomCocktail: LiveData<`[`CocktailDetail`](../../com.example.liquorade.domain/-cocktail-detail/index.md)`>` |
| [status](status.md) | `val status: LiveData<`[`CocktailApiStatus`](../../com.example.liquorade.cocktail/-cocktail-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [getRandomCocktail](get-random-cocktail.md) | `fun getRandomCocktail(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gets the random cocktail details from the Repository and sets the random cocktail details and api status |
