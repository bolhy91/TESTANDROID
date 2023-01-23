package com.bolhy91.connecttest.data.mapper

import com.bolhy91.connecttest.data.local.PersonEntity
import com.bolhy91.connecttest.domain.model.Person

fun Person.toPersonEntity(): PersonEntity {
    return PersonEntity(
        firstName = firstName,
        lastName = lastName,
        phone = phone,
        year = year.toString(),
        make = make,
        model = model,
        color = color,
        plate = plate
    )
}