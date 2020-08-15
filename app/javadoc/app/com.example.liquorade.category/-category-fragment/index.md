[app](../../index.md) / [com.example.liquorade.category](../index.md) / [CategoryFragment](./index.md)

# CategoryFragment

`class CategoryFragment : Fragment`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CategoryFragment()` |

### Properties

| Name | Summary |
|---|---|
| [viewModelFactory](view-model-factory.md) | `lateinit var viewModelFactory: `[`CategoryViewModelFactory`](../-category-view-model-factory/index.md) |

### Functions

| Name | Summary |
|---|---|
| [onAttach](on-attach.md) | `fun onAttach(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method called once the fragment is associated with its activity Tell Dagger to field inject into the fragment |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: `[`Menu`](https://developer.android.com/reference/android/view/Menu.html)`, inflater: `[`MenuInflater`](https://developer.android.com/reference/android/view/MenuInflater.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Specifies the options menu for an activity, the menu resource gets inflated into the menu provided in the callback |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?`<br>Method gets called once the fragment should inflate a view |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Describes what should happen when a MenuItem is selected |
