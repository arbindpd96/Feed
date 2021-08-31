package com.example.feed.adapter

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.R
import com.example.feed.modals.response.Items
import com.squareup.picasso.Picasso


class ItemsAdapter : RecyclerView.Adapter<ItemsViewHolder>() {

    var itemList = ArrayList<Items>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder = ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_view_holder, parent, false))

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        itemList[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int  = itemList.size



}

class ItemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val itemName: AppCompatTextView = itemView.findViewById<AppCompatTextView>(R.id.item_name)
    private val itemCategory: AppCompatTextView = itemView.findViewById<AppCompatTextView>(R.id.item_category)
    private val itemImage: AppCompatImageView = itemView.findViewById<AppCompatImageView>(R.id.item_pic)
    private val itemLike: AppCompatImageView = itemView.findViewById<AppCompatImageView>(R.id.like_item)
    private val add: AppCompatImageView = itemView.findViewById<AppCompatImageView>(R.id.add)
    private val sub: AppCompatImageView = itemView.findViewById<AppCompatImageView>(R.id.dec)
    private val count: AppCompatTextView = itemView.findViewById<AppCompatTextView>(R.id.count)
    private val price: AppCompatTextView = itemView.findViewById<AppCompatTextView>(R.id.price)
    private var countItem = 0
    fun bind(item: Items) {
        itemName.text = item.product_name
        itemCategory.text = item.category_name
        price.text = "$${item.price}"
        Picasso.get().load(item.product_image).fit().centerCrop(Gravity.TOP).into(itemImage)
        itemLike.setOnClickListener {
            Toast.makeText(itemView.context, "Item saved!", Toast.LENGTH_LONG).show()
        }
        add.setOnClickListener { count.text = "${++countItem}" }
        sub.setOnClickListener {
            if(countItem >= 1)count.text = "${--countItem}" }
    }
}