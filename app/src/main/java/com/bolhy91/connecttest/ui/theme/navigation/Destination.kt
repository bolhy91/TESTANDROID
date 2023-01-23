package com.bolhy91.connecttest.ui.theme.navigation

import androidx.navigation.NamedNavArgument


sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object Form : Destination("form")
    object Comments : Destination("comments")
}