package com.example.e_commerce_mvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_mvvm.Domain.CategoryModel
import com.example.e_commerce_mvvm.R
import com.example.e_commerce_mvvm.databinding.ViewholderCategoryBinding

class CategoryAdapter(val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.viewholder>() {

    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1


    class viewholder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.viewholder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleCatTxt.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        if (selectedPosition == position) {
            holder.binding.titleCatTxt.setBackgroundResource(R.drawable.orange_bg)
            holder.binding.titleCatTxt.setTextColor(context.resources.getColor(R.color.white))
        } else {
            holder.binding.titleCatTxt.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.titleCatTxt.setTextColor(context.resources.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int = items.size

}