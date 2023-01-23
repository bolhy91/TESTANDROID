package com.bolhy91.connecttest.data.mapper

import com.bolhy91.connecttest.data.remote.dto.CommentDto
import com.bolhy91.connecttest.domain.model.Comment

fun CommentDto.toComment(): Comment {
    return Comment(
        postId = postId,
        id = id,
        name = name,
        email = email,
        body = body
    )
}