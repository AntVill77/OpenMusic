package com.example.openmusic.navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.openmusic.navigation.AppDestination
import com.example.openmusic.presentation.splash.SplashRoute


fun NavGraphBuilder.splashGraph(

    navController: NavController

) {

    composable(

        AppDestination.Splash.route

    ) {

        SplashRoute(

            navigateHome = {

                navController.navigate(
                    AppDestination.Home.route
                )

            },

            navigateLogin = {

                navController.navigate(
                    AppDestination.Login.route
                )

            }

        )

    }

}