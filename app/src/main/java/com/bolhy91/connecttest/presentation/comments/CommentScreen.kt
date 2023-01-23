package com.bolhy91.connecttest.presentation.comments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bolhy91.connecttest.R
import com.bolhy91.connecttest.ui.theme.blackColor
import com.bolhy91.connecttest.ui.theme.components.CommentItem
import com.bolhy91.connecttest.ui.theme.components.ShimmerLoading

@Composable
fun CommentScreen(viewModel: CommentViewModel = hiltViewModel()) {
    val commentState = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 22.dp,
                end = 22.dp,
                top = 22.dp,
                bottom = 95.dp
            )
    ) {
        Text(
            text = stringResource(R.string.comments), style = TextStyle(
                color = blackColor, fontSize = 30.sp, fontWeight = FontWeight.Bold
            )
        )

        if (commentState.comments.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(commentState.comments.size) { index ->
                    CommentItem(comment = commentState.comments[index])
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }else {
            Column {
                repeat(5) {
                    ShimmerLoading()
                }
            }
        }

    }

}