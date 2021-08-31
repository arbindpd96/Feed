package com.example.feed.adapter

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

class ItemsAdapter() : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    var list: ArrayList<Items>? = null

    inner class ItemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val itemName = itemView.findViewById<AppCompatTextView>(R.id.item_name)
        val itemCategory = itemView.findViewById<AppCompatTextView>(R.id.item_category)
        val itemImage = itemView.findViewById<AppCompatImageView>(R.id.item_pic)
        val itemLike = itemView.findViewById<AppCompatImageView>(R.id.like_item)
        val add = itemView.findViewById<AppCompatImageView>(R.id.add)
        val sub =   itemView.findViewById<AppCompatImageView>(R.id.dec)
        val count = itemView.findViewById<AppCompatTextView>(R.id.count)
        val price = itemView.findViewById<AppCompatTextView>(R.id.price)
        var countItem = 1
        fun bind(item: Items) {
            itemName.text = item.product_name
            itemCategory.text = item.category_name
            price.text = "$${item.price}"
            Picasso.get().load(item.product_image).fit().centerCrop(Gravity.TOP).into(itemImage)
            itemLike.setOnClickListener { Toast.makeText(itemView.context , "Item saved!" , Toast.LENGTH_LONG).show() }
            add.setOnClickListener { count.text = "${++countItem}"}
            sub.setOnClickListener { count.text = "${++countItem}" }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
return ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_view_holder, parent, false))    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
       holder.bind(list?.get(position) ?: return)
    }

    override fun getItemCount(): Int = list?.size ?: 0
}