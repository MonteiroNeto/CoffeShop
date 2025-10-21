package com.example.coffeeshop.ui

import android.app.Activity
import com.example.coffeeshop.databinding.LayoutBottomNavigationBinding
import com.example.coffeeshop.util.OpenActivity

class BottomMenu(
    private val binding: LayoutBottomNavigationBinding,
    private val activity: Activity
) {

    fun startMenu() {
        binding.llBtnCartBottomMenu.setOnClickListener {
            OpenActivity().openCartActivity(activity)
        }
    }

}