package com.bolhy91.connecttest.utils

import android.util.Log

fun findMakeByYear(year: Int): List<String> {
    val myArray = mutableListOf<String>()
    for(car in carsArray) {
        if (car.year == year){
            myArray.add(car.make)
        }
    }
    Log.i("TAG array", myArray.toString())
    return myArray.distinct()
}

fun findMakeByMake(make: String, year: Int): List<String> {
    val myArray = mutableListOf<String>()
    for(car in carsArray) {
        if (car.make == make && car.year == year){
            myArray.add(car.model)
        }
    }
    Log.i("TAG array", myArray.toString())
    return myArray.distinct()
}