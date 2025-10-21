package com.example.coffeeshop.util

import android.app.Activity
import android.content.Intent
import com.example.coffeeshop.ui.CartActivity

class OpenActivity {


    fun openCartActivity(activity: Activity) {
        val intent = Intent(activity, CartActivity::class.java)
        activity.startActivity(intent)
    }
}