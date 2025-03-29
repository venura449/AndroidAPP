
package com.example.mono

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DiscountAdapter(private val itemList: List<DiscountItem>) : RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.discount_item_layout, parent, false)
        return DiscountViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class DiscountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.discount_image)
        private val titleTextView: TextView = itemView.findViewById(R.id.discount_title)

        fun bind(item: DiscountItem) {
            imageView.setImageResource(item.discountImage)
            titleTextView.text = item.discountTitle
        }
    }
}
