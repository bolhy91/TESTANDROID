package com.bolhy91.connecttest.presentation.comments

import com.bolhy91.connecttest.domain.model.Comment

data class CommentListState(
    val comments: List<Comment> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
