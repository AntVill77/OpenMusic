package com.example.openmusic.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.openmusic.navigation.AppDestination

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    composable(
        AppDestination.Home.route
    ) {
        HomeRoute(
            onSongClick = { song ->
                navController.navigate(
                    AppDestination.Detail.createRoute(
                        song.id
                    )
                )
            }
        )
    }
}
