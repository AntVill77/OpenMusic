package com.example.openmusic.navigation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.openmusic.feature.player.presentation.PlayerScreen
import com.example.openmusic.navigation.AppDestination

fun NavGraphBuilder.playerGraph(){

    composable(

        AppDestination.Player.route

    ){

        PlayerScreen()

    }

}