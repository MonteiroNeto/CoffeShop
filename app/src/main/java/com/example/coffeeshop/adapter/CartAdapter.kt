package com.example.coffeeshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.coffeeshop.databinding.ViewholderCartBinding
import com.example.coffeeshop.helper.ChangeNumberItemsListener
import com.example.coffeeshop.helper.ManagmentCart
import com.example.coffeeshop.model.ItemModel

class CartAdapter(
    private val listItemsSelected: ArrayList<ItemModel>,
    context: Context,
    var changeNumberItemsListener: ChangeNumberItemsListener? = null
) : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {

    private val managmentCart = ManagmentCart(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding =
            ViewholderCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val item = listItemsSelected[position]

        holder.binding.tvTitleItemCartViewHolderCart.text = item.title
        holder.binding.tvPriceItemViewHolderCart.text = "$${item.price}"
        holder.binding.tvTotalItemViewHolderCart.text =
            "$${Math.round(item.numberInCart * item.price)}"
        holder.binding.tvNumberItemViewHolderCart.text = item.numberInCart.toString()

        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.ivItemCartViewHolderCart)


        holder.binding.tvPlusItemViewHolderCart.setOnClickListener {
            managmentCart.plusItem(listItemsSelected, position, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener?.onChanged()
                }
            })
        }

        holder.binding.tvMiniumItemViewHolderCart.setOnClickListener {
            managmentCart.minusItem(
                listItemsSelected,
                position,
                object : ChangeNumberItemsListener {
                    override fun onChanged() {
                        notifyDataSetChanged()
                        changeNumberItemsListener?.onChanged()
                    }
                })
        }

        holder.binding.ivRemoveItemCartViewHolderCart.setOnClickListener {
            managmentCart.romoveItem(
                listItemsSelected,
                position,
                object : ChangeNumberItemsListener{
                    override fun onChanged() {
                        notifyDataSetChanged()
                        changeNumberItemsListener?.onChanged()
                    }

                }
            )
        }


    }

    override fun getItemCount(): Int = listItemsSelected.size


    class MyViewHolder(val binding: ViewholderCartBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}