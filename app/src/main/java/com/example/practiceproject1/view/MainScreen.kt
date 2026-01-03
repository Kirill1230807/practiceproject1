package com.example.practiceproject1.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practiceproject1.model.Product
import com.example.practiceproject1.ui.theme.component.Header
import com.example.practiceproject1.ui.theme.component.ProductCard
import com.example.practiceproject1.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: ProductViewModel,
    navController: NavController
) {
    val products = viewModel.products
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 16.dp)
                        .height(56.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Logo")
                        Spacer(Modifier.width(6.dp))
                        Text("My Test App")
                    }
                    IconButton(onClick = {/* TODO */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("Add") }) {
                Icon(Icons.Default.Add, contentDescription = "Add button")
            }
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            items(products) { product ->
                Row {
                    ProductCard(
                        product,
                        onDelete = { viewModel.deleteProduct(product) },
                        navController = navController
                    )
                }
            }
        }

    }
}