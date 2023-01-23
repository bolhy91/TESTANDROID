package com.bolhy91.connecttest.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerLoading() {

    val brushColor = linearGradient(
        listOf(
            Color.Gray.copy(alpha = 0.9f),
            Color.Gray.copy(alpha = 0.4f),
            Color.Gray.copy(alpha = 0.9f)
        )
    )

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(20.dp)
                        .shimmer()
                        .background(brushColor)
                )
                Spacer(
                    modifier = Modifier.height(7.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(20.dp)
                        .shimmer()
                        .background(brushColor)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}

@Preview
@Composable
fun ShimmerPreview() {
    ShimmerLoading()
}