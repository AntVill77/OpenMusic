package com.example.openmusic.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.openmusic.feature.player.presentation.component.MiniPlayer
import com.example.openmusic.navigation.AppNavHost

@Composable
fun AppScaffold() {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {

            MiniPlayer(

                onClick = {

                    navController.navigate("player")

                }

            )

        }

    ) { padding ->

        AppNavHost(

            navController = navController,

            modifier = Modifier.padding(padding)

        )

    }

}