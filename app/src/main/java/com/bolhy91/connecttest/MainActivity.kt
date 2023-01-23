package com.bolhy91.connecttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.bolhy91.connecttest.ui.theme.ConnecttestTheme
import com.bolhy91.connecttest.ui.theme.components.BaseLayoutScreen
import com.bolhy91.connecttest.ui.theme.navigation.ConnectNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnecttestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val selectedItemIndexMenu = remember { mutableStateOf(0) }

                    BaseLayoutScreen(
                        navController = navController, selectedItemIndexMenu = selectedItemIndexMenu
                    ) {
                        ConnectNavGraph(navHostController = navController)
                    }
                }
            }
        }
    }
}