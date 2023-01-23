package com.bolhy91.connecttest.data.repository

import android.util.Log
import com.bolhy91.connecttest.data.local.PersonDao
import com.bolhy91.connecttest.data.mapper.toPersonEntity
import com.bolhy91.connecttest.domain.model.Person
import com.bolhy91.connecttest.domain.repository.FormRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FormRepositoryImpl @Inject constructor(
    private val personDao: PersonDao
) : FormRepository {
    override suspend fun insertPerson(person: Person): Flow<Boolean> = flow {
        try {
            val insertPerson = personDao.insertPerson(person.toPersonEntity())
            Log.i("TAG INSERT: ", insertPerson.toString())
            emit(true)
        } catch (e: Exception) {
            e.printStackTrace()
            emit(false)
        }
    }
}