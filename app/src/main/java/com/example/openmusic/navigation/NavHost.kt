package com.example.openmusic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.openmusic.navigation.navigation.authGraph
import com.example.openmusic.navigation.navigation.splashGraph
import com.example.openmusic.feature.detail.detailGraph
import com.example.openmusic.feature.home.homeGraph
import com.example.openmusic.navigation.navigation.playerGraph


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {

    NavHost(

        navController = navController,

        startDestination = AppDestination.Splash.route

    ) {

        splashGraph(navController)

        authGraph(navController)

        homeGraph(navController)

        detailGraph(navController)

        playerGraph()

    }

}