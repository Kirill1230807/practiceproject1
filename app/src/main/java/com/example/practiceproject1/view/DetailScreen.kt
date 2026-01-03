package com.example.practiceproject1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practiceproject1.R
import com.example.practiceproject1.model.Product
import com.example.practiceproject1.ui.theme.component.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    product: Product,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Header() })
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                Modifier.size(230.dp)
            )
            Spacer(Modifier.height(12.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(1.dp, Color.Gray)
            ) {

                Row(
                    Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    Text("ID", Modifier.weight(0.5f), fontWeight = FontWeight.Bold)
                    Text("Товар", Modifier.weight(0.5f), fontWeight = FontWeight.Bold)
                    Text("Ціна", Modifier.weight(0.5f), fontWeight = FontWeight.Bold)
                }
                HorizontalDivider()
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text("${product.id}", Modifier.weight(0.5f))
                    Text(product.name, Modifier.weight(0.5f))
                    Text("${product.price} грн", Modifier.weight(0.5f))
                }
            }
            Button(onClick = { navController.popBackStack() }) {
                Text("Назад")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    val product = Product(
        id = 1,
        name = "Футболка чорна",
        price = 200.00,
        imageRes = R.drawable.black_tshirt
    )
    DetailScreen(product, navController = rememberNavController())
}