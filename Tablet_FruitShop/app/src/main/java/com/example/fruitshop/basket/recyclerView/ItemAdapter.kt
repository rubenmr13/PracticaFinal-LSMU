package com.example.fruitshop.basket.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitshop.R
import com.example.fruitshop.basket.Item

class ItemAdapter (
    var itemList: List<Item>,
    val removeItem: (Int) ->Unit
) : RecyclerView.Adapter<ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.pintar(item, removeItem)
    }

    fun actualizarAdapter(list: List<Item>){
        val diffUtil = DiffUtilsCallback(itemList, list)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffUtil)
        diffResult.dispatchUpdatesTo(this)

        itemList = list
    }

    fun getTamanio(): Int = itemList.size
}