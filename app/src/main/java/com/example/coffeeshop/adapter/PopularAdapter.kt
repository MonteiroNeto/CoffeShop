package com.example.coffeeshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop.databinding.ViewholderPopularBinding
import com.example.coffeeshop.model.ItemModel

class PopularAdapter(val items: MutableList<ItemModel>) :
    RecyclerView.Adapter<PopularAdapter.MyViewHolder>() {
    lateinit var context: Context


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        context = parent.context
        val binding =
            ViewholderPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.tvTitleViewHolderPopular.text = item.title
        holder.binding.tvExtraViewHolderPopular.text = item.extra
        holder.binding.tvPriceViewHolderPopular.text = "$ ${item.price}"

        Glide.with(context)
            .load(item.picUrl[0])
            .into(holder.binding.shapeIvViewHolderPopular)
    }

    override fun getItemCount(): Int = items.size


    class MyViewHolder(val binding: ViewholderPopularBinding) :
        RecyclerView.ViewHolder(binding.root)
}