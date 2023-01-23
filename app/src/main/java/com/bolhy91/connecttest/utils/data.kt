package com.bolhy91.connecttest.utils

import androidx.annotation.DrawableRes
import com.bolhy91.connecttest.R


data class Car(
    val year: Int, val make: String, val model: String, val color: String, val plate: String
)

val carsArray: List<Car> = listOf(
    Car(2020, "Acura", "TLX", "red", "1234565"),
    Car(2020, "Acura", "RDX", "green", "1234565"),
    Car(2020, "Toyota", "Yaris", "black", "1234565"),
    Car(2020, "Toyota", "Corolla", "white", "1234565"),
    Car(2019, "Toyota", "Camry", "yellow", "1234565"),
    Car(2019, "Hyundai", "Elantra", "blue", "1234565"),
    Car(2019, "Hyundai", "Tucson", "purple", "1234565"),
)

data class Menu(val id: Int, val title: String, @DrawableRes val icon: Int, val url: String)

val menuItems: List<Menu> = listOf(
    Menu(1, "Form", R.drawable.ic_home, "form"),
    Menu(2, "Comments", R.drawable.comment_svgrepo_com, "comments"),
)