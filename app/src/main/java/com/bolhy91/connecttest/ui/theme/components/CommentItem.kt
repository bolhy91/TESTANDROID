package com.bolhy91.connecttest.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bolhy91.connecttest.domain.model.Comment
import com.bolhy91.connecttest.ui.theme.inputColor
import com.bolhy91.connecttest.ui.theme.orange

@Composable
fun CommentItem(
    comment: Comment,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(inputColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "NAME: ${comment.name}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "EMAIL: ${comment.email}",
                    style = MaterialTheme.typography.subtitle2,
                    color = orange
                )
                Text(
                    text = comment.body,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black
                )
            }
            Text(
                text = "ID: ${comment.id}",
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.Bold,
                    color = orange,
                    fontSize = 16.sp
                )
            )
        }
    }
}