package com.example.fruitshop.basket.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.example.fruitshop.basket.Item

class DiffUtilsCallback(val oldList: List<Item>, val newList: List<Item>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].textItem == newList[newItemPosition].textItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].textItem == newList[newItemPosition].textItem
                && oldList[oldItemPosition].itemImage == newList[newItemPosition].itemImage
    }

}