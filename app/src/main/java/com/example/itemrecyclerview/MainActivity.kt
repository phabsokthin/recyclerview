package com.example.itemrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itemrecyclerview.Adapter.ItemAdapter
import com.example.itemrecyclerview.Model.ItemModel

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    val imageName = arrayOf(

        ItemModel("Blue Cake", "Price: $20.00",R.drawable.cake),
        ItemModel("Burry Cake","Price: $23.00",R.drawable.cake1),
        ItemModel("Fruite Cake", "Price: $22.00", R.drawable.cake2),
        ItemModel("Max Cake", "Price: $30.00", R.drawable.cake3),
        ItemModel("Jurry Cake", "Price: $50.00", R.drawable.cake4),
        ItemModel("Khmer Cake", "Price: $43.00", R.drawable.cake5),
        ItemModel("Black Cake", "Price: $23.00", R.drawable.cake6),
        ItemModel("Red Cake", "Price: $58.00", R.drawable.cake7)
    )

    val itemModelList = ArrayList<ItemModel>()

    var itemAdapter: ItemAdapter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)

        for (items in imageName){
            itemModelList.add(items)
        }

        itemAdapter = ItemAdapter(this)
        itemAdapter !!.setData(itemModelList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemAdapter
    }

     fun ClickedItem(itemModel: ItemModel){

         Log.e("Tage", itemModel.title1)

         when(itemModel.title1){
             "Blue Cake" -> startActivity(Intent(this@MainActivity, Item1::class.java))
             "Burry Cake" -> startActivity(Intent(this@MainActivity, Item2::class.java))
             "Fruite Cake" -> startActivity(Intent(this@MainActivity, item3::class.java))

             else -> {

                 Toast.makeText(this, "No Layout", Toast.LENGTH_SHORT).show()

             }
         }


    }
}