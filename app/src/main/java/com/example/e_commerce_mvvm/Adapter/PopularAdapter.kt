package com.example.e_commerce_mvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce_mvvm.Domain.ItemsModel
import com.example.e_commerce_mvvm.databinding.ViewholderPopularBinding

class PopularAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<PopularAdapter.Viewholder>() {
    lateinit var contex: Context

    class Viewholder(val binding: ViewholderPopularBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.Viewholder {
        contex = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(contex), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$" + items[position].price.toString()

        Glide.with(contex)
            .load(items[position].thumbnail)
            .into(holder.binding.pic)
    }

    override fun getItemCount(): Int = items.size

}