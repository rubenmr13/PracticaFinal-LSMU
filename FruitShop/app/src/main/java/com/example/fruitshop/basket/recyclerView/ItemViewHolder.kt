package com.example.fruitshop.basket.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitshop.basket.Item
import com.example.fruitshop.databinding.ItemLayoutBinding

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemLayoutBinding.bind(view)

    fun pintar(items: Item, removeItem: (Int)->Unit){
        binding.itemText.text = items.textItem
        binding.itemImage.setImageResource(items.itemImage)

        binding.btnRemoveItem.setOnClickListener {
            removeItem(bindingAdapterPosition)
        }
    }
}