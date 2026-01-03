package com.example.practiceproject1.view

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practiceproject1.R
import com.example.practiceproject1.model.Product
import com.example.practiceproject1.ui.theme.component.ImageCard
import com.example.practiceproject1.viewmodel.ProductViewModel
import kotlin.time.Duration.Companion.days

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(
    navController: NavController,
    viewModel: ProductViewModel
) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var selectedImageRes by remember { mutableIntStateOf(0) }

    val imageList = listOf(
        R.drawable.black_tshirt,
        R.drawable.red_cap,
        R.drawable.yellow_shorts,
        R.drawable.blue_sneakers
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
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
                    }
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { inputName -> name = inputName },
                label = { Text("Назва товару") },
                placeholder = { Text("Введіть назву товару.") }
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = price,
                onValueChange = { inputPrice -> price = inputPrice },
                label = { Text("Ціна") },
                placeholder = { Text("0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.height(12.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Оберіть зображення", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(12.dp))
                Row(
                    Modifier.horizontalScroll(rememberScrollState())
                ) {
                    for (image in imageList) {
                        ImageCard(
                            image,
                            onClick = { selectedImageRes = image },
                            isSelected = (selectedImageRes == image)
                        )
                    }
                }
            }
            Spacer(Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.spacedBy(50.dp),
            ) {
                Button(onClick = { navController.popBackStack() }) {
                    Text("Скасувати")
                    Log.INFO
                }

                Button(
                    onClick = {
                        val finalPrice: Double = price.toDoubleOrNull() ?: 0.0

                        if (name.isNotEmpty() && finalPrice > 0 && selectedImageRes != 0) {
                            viewModel.addProduct(
                                name = name,
                                price = finalPrice,
                                imageRes = selectedImageRes
                            )
                            navController.popBackStack()
                        }
                    },
                    enabled = name.isNotEmpty() && selectedImageRes != 0
                ) {
                    Text("Додати товар")
                    Log.INFO
                }

            }
        }
    }
}