package com.example.coffeeshop.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
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