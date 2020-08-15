[app](../../index.md) / [com.example.liquorade.category](../index.md) / [CategoryAdapter](./index.md)

# CategoryAdapter

`class CategoryAdapter : ListAdapter<`[`Category`](../../com.example.liquorade.domain/-category/index.md)`, `[`CategoryViewHolder`](-category-view-holder/index.md)`>`

### Types

| Name | Summary |
|---|---|
| [CategoryViewHolder](-category-view-holder/index.md) | `class CategoryViewHolder : ViewHolder` |
| [DiffCallback](-diff-callback/index.md) | `companion object DiffCallback : ItemCallback<`[`Category`](../../com.example.liquorade.domain/-category/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CategoryAdapter(click: `[`OnClickListener`](../-on-click-listener/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`CategoryViewHolder`](-category-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method that updates the content of the RecyclerView When a row (view) of the RecyclerView gets scrolled off the screen, the view gets recycled and new data is bound to the view |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CategoryViewHolder`](-category-view-holder/index.md)<br>Creates the ViewHolder for the RecyclerView |

### Companion Object Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`Category`](../../com.example.liquorade.domain/-category/index.md)`, newItem: `[`Category`](../../com.example.liquorade.domain/-category/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Method that checks if content of the items are the same |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`Category`](../../com.example.liquorade.domain/-category/index.md)`, newItem: `[`Category`](../../com.example.liquorade.domain/-category/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Method that checks if items are the same |
