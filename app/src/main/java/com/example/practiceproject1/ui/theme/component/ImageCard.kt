package com.example.practiceproject1.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageCard(
    imageRes: Int,
    onClick: () -> Unit,
    isSelected: Boolean
) {

    Card(
        Modifier
            .width(200.dp)
            .padding(8.dp)
            .clickable(onClick = onClick)
            .border(
                width = if (isSelected) 4.dp else 0.dp,
                color = if (isSelected) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier.padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
        }
    }
}