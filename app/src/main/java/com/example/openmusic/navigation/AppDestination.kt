package com.example.openmusic.navigation

sealed class AppDestination(
    val route: String
) {

    data object Splash :
        AppDestination("splash")

    data object Login :
        AppDestination("login")

    data object Home :
        AppDestination("home")

    data object Detail :
        AppDestination("detail/{songId}") {

        fun createRoute(
            songId:String
        ) =
            "detail/$songId"

    }

}