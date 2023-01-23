package com.bolhy91.connecttest.data.repository

import android.util.Log
import com.bolhy91.connecttest.data.mapper.toComment
import com.bolhy91.connecttest.data.remote.CommentApi
import com.bolhy91.connecttest.data.remote.dto.CommentListDto
import com.bolhy91.connecttest.domain.model.Comment
import com.bolhy91.connecttest.domain.repository.CommentRepository
import com.bolhy91.connecttest.utils.Resource
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi
) : CommentRepository {
    override suspend fun getComments(page: Int): Flow<Resource<List<Comment>>> {
        return flow {
            emit(Resource.Loading(true))
            val remoteComments= try {
                val results = commentApi.getComments()
                Log.i("TAG REMOTE ", results.toString())
                results
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("couldn't load data ${e.message}"))
                null
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("couldn't load data http: ${e.message}"))
                null
            }
            delay(300)
            remoteComments?.let { results ->
                emit(Resource.Success(data = results.map { it.toComment() }))
                emit(Resource.Loading(false))
            }
        }
    }

    private fun convertGson(jsonString: String): CommentListDto {
        val gson = Gson()
        return gson.fromJson(jsonString, CommentListDto::class.java)
    }

}