package supahsoftware.androidexamplecarousel

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val itemAdapter by lazy {
        ItemAdapter { position: Int, item: Item ->
            Toast.makeText(this@MainActivity, "Pos ${position}", Toast.LENGTH_LONG).show()
            item_list.smoothScrollToPosition(position)
        } }
    private val possibleItems = listOf(
        Item("", R.drawable.pager_one),
        Item("", R.drawable.pager_two),
        Item("", R.drawable.pager_three)
      /*  Item("", R.drawable.ic_gas),
        Item("", R.drawable.ic_home)*/
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        item_list.initialize(itemAdapter)
        item_list.setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
     //   itemAdapter.setItems(getLargeListOfItems())
        itemAdapter.setItems((possibleItems))
    }

   /* private fun getLargeListOfItems(): List<Item> {
        val items = mutableListOf<Item>()
      //  (0..4).map { items.add(possibleItems.size) }
       (0..4).map { items.add(possibleItems.random()) }
        return items
    }*/
}

data class Item(
    val title: String,
    @DrawableRes val icon: Int
)