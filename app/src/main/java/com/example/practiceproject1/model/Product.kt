package com.example.practiceproject1.model

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    @DrawableRes val imageRes: Int
)
