package com.example.coffeeshop.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coffeeshop.adapter.PopularAdapter
import com.example.coffeeshop.databinding.ActivityItemsListBinding
import com.example.coffeeshop.view_model.MainViewModel

class ItemsListActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemsListBinding
    private val viewModel = MainViewModel()
    private var id: String = ""
    private var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityItemsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        get_Bundle()
        initListAdapter()
    }

    private fun initListAdapter() {
        binding.apply {
            progressBarActItemsList.visibility = View.VISIBLE

            viewModel.loadItemsCategory(id).observe(this@ItemsListActivity, Observer {
                rvListView.layoutManager = GridLayoutManager(this@ItemsListActivity, 2)
                rvListView.adapter = PopularAdapter(it)
                progressBarActItemsList.visibility = View.GONE
            })
            llBtnBackActItemsList.setOnClickListener { finish() }
        }

    }

    private fun get_Bundle() {
        id = intent.getStringExtra("id")!!
        title = intent.getStringExtra("title")!!

        binding.tvItemTitleActItemsList.text = title
    }
}