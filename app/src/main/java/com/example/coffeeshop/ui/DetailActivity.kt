package com.example.coffeeshop.ui

import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.coffeeshop.adapter.CoffeeSizeAdapter
import com.example.coffeeshop.databinding.ActivityDetailBinding
import com.example.coffeeshop.helper.ManagmentCart
import com.example.coffeeshop.model.ItemModel
import com.example.coffeeshop.util.Constant
import eightbitlab.com.blurview.RenderScriptBlur

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemModel
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        bundle()
        setBlurEffect()
        initCoffeeSizeAdapter()
    }

    private fun initCoffeeSizeAdapter() {
        val listCoffeeSize = ArrayList<String>()
        listCoffeeSize.add("1")
        listCoffeeSize.add("2")
        listCoffeeSize.add("3")
        listCoffeeSize.add("4")

        binding.rvCoffeeSizeListActDetail.adapter = CoffeeSizeAdapter(listCoffeeSize)
        binding.rvCoffeeSizeListActDetail.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val colorList = ArrayList<String>()
        for (imgUrl in item.picUrl) {
            colorList.add(imgUrl)
        }

        Glide.with(this)
            .load(colorList[0])
            .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
            .into(binding.shapeIvItemDetailActDetail)
    }

    private fun setBlurEffect() {
        val radius = 10f
        val decorView = this.window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowsBackground = decorView.background

        binding.blurViewActDetail.setupWith(rootView, RenderScriptBlur(this))
            .setFrameClearDrawable(windowsBackground)
            .setBlurRadius(radius)

        binding.blurViewActDetail.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binding.blurViewActDetail.clipToOutline = true
    }

    private fun bundle() {
        binding.apply {
            item = intent.getSerializableExtra(Constant().ITEM_SERIALIZABLE) as ItemModel

            Glide.with(this@DetailActivity)
                .load(item.picUrl[0])
                .into(binding.shapeIvItemDetailActDetail)

            tvTitleActDetail.text = item.title
            tvDescriptionsActDetail.text = item.description
            tvValueProductActDetail.text = "$${item.price}"
            tvRatingNumberActDetail.text = item.rating.toString()
            tvExtraActDetail.text = item.extra

            btnAddInCartActDetail.setOnClickListener {
                item.numberInCart = Integer.parseInt(tvNumberItemsInCartActDetail.text.toString())
                managmentCart.insertItems(item)
            }

            llBtnBackActDetail.setOnClickListener { finish() }

            tvAddPlusInCartActDetail.setOnClickListener {
                tvNumberItemsInCartActDetail.text = (item.numberInCart + 1).toString()
                item.numberInCart++
            }

            tvMinusInCartActDetail.setOnClickListener {
                if (item.numberInCart > 0) {
                    tvNumberItemsInCartActDetail.text = (item.numberInCart - 1).toString()
                    item.numberInCart--
                }
            }
        }
    }
}