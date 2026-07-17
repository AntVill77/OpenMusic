package com.example.openmusic.presentation.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.openmusic.navigation.AppDestination

fun NavGraphBuilder.detailGraph(
    navController: NavController
) {
    composable(
        route = AppDestination.Detail.route
    ) {
        DetailRoute()
    }
}
