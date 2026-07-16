package com.example.openmusic.presentation.navigation

import androidx.compose.runtime.Composable

sealed class Screen(
    val route:String
){

    object Splash:
        Screen("splash")


    object Login:
        Screen("login")


    object Home:
        Screen("home")

}


@Composable
fun OpenMusicNavigation(){

   /* val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
    }*/
}