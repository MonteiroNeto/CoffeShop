package com.example.coffeeshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.ViewholderSizeBinding

class CoffeeSizeAdapter(val items: MutableList<String>) :
    RecyclerView.Adapter<CoffeeSizeAdapter.MyViewHolder>() {


    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        context = parent.context
        val binding = ViewholderSizeBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val imageSize = when (position) {
            0 -> 45.dpToPx(context)
            1 -> 50.dpToPx(context)
            2 -> 55.dpToPx(context)
            3 -> 60.dpToPx(context)
            else -> 65.dpToPx(context)
        }

        val layoutParams = holder.binding.ivImageViewHolderSize.layoutParams
        layoutParams.width = imageSize
        layoutParams.height = imageSize
        holder.binding.ivImageViewHolderSize.layoutParams = layoutParams

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if (selectedPosition == position){
            holder.binding.ivImageViewHolderSize.setBackgroundResource(R.drawable.shape_orange_bg)
        }else{
            holder.binding.ivImageViewHolderSize.setBackgroundResource(R.drawable.shape_stroke_bg)
        }
    }

    override fun getItemCount(): Int = items.size


    class MyViewHolder(val binding: ViewholderSizeBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    //===========FUNCTIONS================
    private fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}