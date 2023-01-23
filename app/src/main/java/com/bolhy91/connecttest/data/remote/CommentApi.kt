package com.bolhy91.connecttest.data.remote

import com.bolhy91.connecttest.data.remote.dto.CommentDto
import retrofit2.http.GET

interface CommentApi{
    @GET("comments?postId=1")
    suspend fun getComments(): List<CommentDto>
}