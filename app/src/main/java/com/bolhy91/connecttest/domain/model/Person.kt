package com.bolhy91.connecttest.domain.model

import androidx.compose.runtime.MutableState

data class Person(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val year: Int,
    val make: String,
    val model: String,
    val color: String,
    val plate: String
)