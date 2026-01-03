package com.example.practiceproject1.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.practiceproject1.R
import com.example.practiceproject1.model.Product

class ProductViewModel : ViewModel() {
    private val _products = mutableStateListOf(

        Product(1, "Футболка чорна", 150.0, R.drawable.black_tshirt),
        Product(2, "Блакитні кросівки", 200.0, R.drawable.blue_sneakers),
        Product(3, "Футболка чорна", 150.0, R.drawable.black_tshirt),
        Product(4, "Блакитні кросівки", 200.0, R.drawable.blue_sneakers),
        Product(5, "Блакитні кросівки", 200.0, R.drawable.blue_sneakers),
        Product(6, "Футболка чорна", 150.0, R.drawable.black_tshirt),
        Product(7, "Блакитні кросівки", 200.0, R.drawable.blue_sneakers),
        Product(8, "Червона кепка", 150.0, R.drawable.red_cap),
        Product(9, "Футболка чорна", 150.0, R.drawable.black_tshirt),
        Product(10, "Червона кепка", 150.0, R.drawable.red_cap),
        Product(11, "Червона кепка", 150.0, R.drawable.red_cap),
        Product(12, "Жовті шорти", 150.0, R.drawable.yellow_shorts),
        Product(13, "Жовті шорти", 150.0, R.drawable.yellow_shorts),
        Product(14, "Футболка чорна", 150.0, R.drawable.black_tshirt),
        Product(15, "Жовті шорти", 150.0, R.drawable.yellow_shorts),
        Product(16, "Червона кепка", 150.0, R.drawable.red_cap),
        Product(17, "Жовті шорти", 150.0, R.drawable.yellow_shorts),
        Product(18, "Блакитні кросівки", 200.0, R.drawable.blue_sneakers),
        Product(19, "Жовті шорти", 150.0, R.drawable.yellow_shorts),
    )

    val products: List<Product> get() = _products

    fun addProduct(name: String, price: Double, imageRes: Int) {
        val newId = (_products.maxOfOrNull { it.id } ?: 0) + 1

        val newProduct = Product(
            id = newId,
            name = name,
            price = price,
            imageRes = imageRes
        )

        _products.add(0, newProduct)
    }

    fun deleteProduct(product: Product): Boolean {
        return _products.remove(product)
    }

    fun getProductById(id: Int): Product? {
        return _products.find { it.id == id }
    }
}