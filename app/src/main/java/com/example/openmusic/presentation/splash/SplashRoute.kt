package com.example.openmusic.presentation.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.openmusic.presentation.screens.SplashScreen

@Composable
fun SplashRoute(

    navigateHome: () -> Unit,

    navigateLogin: () -> Unit,

    viewModel: SplashViewModel = hiltViewModel()

) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.destination) {

        when (state.destination) {

            SplashDestination.Home ->
                navigateHome()

            SplashDestination.Login ->
                navigateLogin()

            SplashDestination.None -> Unit

        }

    }

    SplashScreen()

}