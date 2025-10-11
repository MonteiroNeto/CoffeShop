package com.example.coffeeshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop.databinding.ViewholderSpecialBinding
import com.example.coffeeshop.model.ItemModel

class SpecialAdapter(val items: MutableList<ItemModel>) :
    RecyclerView.Adapter<SpecialAdapter.MyViewHolder>() {
    lateinit var context: Context


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        context = parent.context
        val binding =
            ViewholderSpecialBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.tvTitleViewHolderSpecial.text = item.title
        holder.binding.ratingBarSpecialViewHolderSpecial.rating = item.rating.toFloat()
        holder.binding.tvPriceViewHolderSpecial.text = "$ ${item.price}"

        Glide.with(context)
            .load(item.picUrl[0])
            .into(holder.binding.shapeIvSpecialViewHolderSpecial)
    }

    override fun getItemCount(): Int = items.size


    class MyViewHolder(val binding: ViewholderSpecialBinding) :
        RecyclerView.ViewHolder(binding.root)
}