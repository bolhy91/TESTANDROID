package com.bolhy91.connecttest.domain.repository

import com.bolhy91.connecttest.domain.model.Comment
import com.bolhy91.connecttest.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    suspend fun getComments(page: Int = 1): Flow<Resource<List<Comment>>>
}