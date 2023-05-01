package com.example.itemrecyclerview.Adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itemrecyclerview.Model.ItemModel
import com.example.itemrecyclerview.R
import android.view.LayoutInflater
import android.widget.ImageView
import com.example.itemrecyclerview.MainActivity

class ItemAdapter(var clickListener: MainActivity): RecyclerView.Adapter<ItemAdapter.ItemAdatperViewHolder>() {


    var itemModelList = ArrayList<ItemModel>()

    fun setData(itemModelList: ArrayList<ItemModel>){
        this.itemModelList = itemModelList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdatperViewHolder {

        return ItemAdatperViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))

    }

    override fun onBindViewHolder(holder: ItemAdatperViewHolder, position: Int) {

        val itemModel = itemModelList[position]
        holder.title1.text = itemModel.title1
        holder.title2.text = itemModel.title2
        holder.image.setImageResource(itemModel.image)

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemModel)
        }

    }

    override fun getItemCount(): Int {
        return itemModelList.size
    }
    class ItemAdatperViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val title1 = itemView.findViewById<TextView>(R.id.title1)
        val title2 = itemView.findViewById<TextView>(R.id.title2)
        val image = itemView.findViewById<ImageView>(R.id.image)

    }
    interface ClickListener{
        fun ClickedItem(itemModel: ItemModel)
    }

}