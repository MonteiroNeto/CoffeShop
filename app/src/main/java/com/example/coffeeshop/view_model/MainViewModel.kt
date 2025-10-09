package com.example.coffeeshop.view_model

import androidx.lifecycle.LiveData
import com.example.coffeeshop.model.CategoryModel
import com.example.coffeeshop.repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }
}