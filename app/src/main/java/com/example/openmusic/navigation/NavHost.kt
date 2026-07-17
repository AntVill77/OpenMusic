package com.example.openmusic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.openmusic.navigation.navigation.authGraph
import com.example.openmusic.navigation.navigation.splashGraph
import com.example.openmusic.presentation.detail.detailGraph
import com.example.openmusic.presentation.home.homeGraph


@Composable
fun AppNavHost(
    navController: NavHostController
) {

    NavHost(

        navController = navController,

        startDestination = AppDestination.Splash.route

    ) {

        splashGraph(navController)

        authGraph(navController)

        homeGraph(navController)

        detailGraph(navController)

    }

}