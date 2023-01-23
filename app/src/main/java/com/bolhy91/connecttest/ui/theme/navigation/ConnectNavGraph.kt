package com.bolhy91.connecttest.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bolhy91.connecttest.presentation.comments.CommentScreen
import com.bolhy91.connecttest.presentation.form.FormScreen

@Composable
fun ConnectNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Destination.Form.route) {
        form()
        comments()
    }
}

fun NavGraphBuilder.form(){
    composable(route = Destination.Form.route){
        FormScreen()
    }
}

fun NavGraphBuilder.comments(){
    composable(route = Destination.Comments.route){
        CommentScreen()
    }
}