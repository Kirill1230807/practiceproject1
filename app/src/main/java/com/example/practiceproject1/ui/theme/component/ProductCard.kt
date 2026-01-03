package com.example.practiceproject1.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practiceproject1.R
import com.example.practiceproject1.model.Product
import com.example.practiceproject1.view.DetailScreen
import com.example.practiceproject1.viewmodel.ProductViewModel

@Composable
fun ProductCard(
    product: Product,
    onDelete: () -> Unit,
    navController: NavController
) {
    Card(
        Modifier
            .width(200.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier.padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    product.name,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Text("${product.price}", textAlign = TextAlign.Center)
            }
            Spacer(Modifier.height(8.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                DetailButton(onClick = { navController.navigate("details/${product.id}") }, modifier = Modifier.weight(1f))
                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    val product = Product(
        id = 1,
        name = "Моя іііііііііівфівфвіфвчорна футболка",
        price = 199.99,
        imageRes = R.drawable.black_tshirt
    )
    ProductCard(
        product,
        onDelete = { /*TODO*/ },
        navController = rememberNavController()
    )
}