package com.example.coffeeshop.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop.adapter.CategoryAdapter
import com.example.coffeeshop.databinding.ActivityMainBinding
import com.example.coffeeshop.view_model.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initCategoryAdapter()
    }

    private fun initCategoryAdapter() {
        binding.progressbarCategoryActMain.visibility = View.VISIBLE
        mainViewModel.loadCategory().observeForever {
            binding.rvCategoryActMain.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.progressbarCategoryActMain.visibility = View.GONE
            binding.rvCategoryActMain.adapter = CategoryAdapter(it)
        }

        mainViewModel.loadCategory()
    }
}