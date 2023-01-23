package com.bolhy91.connecttest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class PersonEntity(
    @PrimaryKey
    val id: Int = -1,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val year: String,
    val make: String,
    val model: String,
    val color: String,
    val plate: String
)