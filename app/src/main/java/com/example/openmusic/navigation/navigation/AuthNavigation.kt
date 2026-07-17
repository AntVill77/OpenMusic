package com.example.openmusic.navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.openmusic.navigation.AppDestination
import com.example.openmusic.presentation.login.LoginRoute


fun NavGraphBuilder.authGraph(

    navController: NavController

) {

    composable(

        AppDestination.Login.route

    ) {

        LoginRoute(

            onLoginSuccess = {

                navController.navigate(
                    AppDestination.Home.route
                )

            }

        )

    }

}