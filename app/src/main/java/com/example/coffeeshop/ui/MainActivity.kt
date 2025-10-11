package com.example.coffeeshop.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop.adapter.CategoryAdapter
import com.example.coffeeshop.adapter.PopularAdapter
import com.example.coffeeshop.adapter.SpecialAdapter
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

        initPopularAdapter()

        initSpecialAdapter()
    }

    private fun initSpecialAdapter() {
        binding.progressbarSpecialActMain.visibility = View.VISIBLE
        mainViewModel.loadSpecial().observeForever {
            binding.rvSpecialActMain.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.progressbarSpecialActMain.visibility = View.GONE
            binding.rvSpecialActMain.adapter = SpecialAdapter(it)
        }

        mainViewModel.loadSpecial()
    }

    private fun initPopularAdapter() {
        binding.progressbarPopularActMain.visibility = View.VISIBLE
        mainViewModel.loadPopular().observeForever {
            binding.rvPopularActMain.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.progressbarPopularActMain.visibility = View.GONE
            binding.rvPopularActMain.adapter = PopularAdapter(it)
        }

        mainViewModel.loadCategory()
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