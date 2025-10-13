package com.example.coffeeshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.ViewholderCategoryBinding
import com.example.coffeeshop.model.CategoryModel
import com.example.coffeeshop.ui.ItemsListActivity
import com.google.firebase.database.Transaction
import java.util.logging.Handler


class CategoryAdapter(val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.MyViewHolder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryAdapter.MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val item = items[position]
        holder.binding.tvTitleViewHolderCategory.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            android.os.Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(context, ItemsListActivity::class.java).apply {
                    putExtra("id", item.id.toString())
                    putExtra("title", item.title)
                }
                ContextCompat.startActivity(context, intent, null)
            },500)
        }

        if (selectedPosition == position) {
            holder.binding.tvTitleViewHolderCategory.setBackgroundResource(R.drawable.shape_brown_bg)
        } else {
            holder.binding.tvTitleViewHolderCategory.setBackgroundResource(R.drawable.shape_dark_brown_bg)
        }


    }

    override fun getItemCount(): Int = items.size

    class MyViewHolder(
        val binding: ViewholderCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root)

}