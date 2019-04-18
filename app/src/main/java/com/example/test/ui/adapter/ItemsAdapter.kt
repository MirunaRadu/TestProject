package com.example.test.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.data.model.Item
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemsAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var itemsList: MutableList<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false), onItemClickListener)


    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(itemsList[position])

    fun reloadList(items: List<Item>) {
        itemsList.clear()
        itemsList.addAll(items)
        notifyDataSetChanged()
    }


    class ItemViewHolder(private val view: View, private val onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        fun bind(item: Item) = with(itemView) {
            tvId.text = item.id.toString()
            tvName.text = item.name
            itemView.setOnClickListener { onItemClickListener.onItemClicked(item) }
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(item: Item)
    }
}
