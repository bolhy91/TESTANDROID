package com.bolhy91.connecttest.domain.repository

import com.bolhy91.connecttest.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface FormRepository {
    suspend fun insertPerson(person: Person): Flow<Boolean>
}