package com.example.openmusic.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.openmusic.domain.viewmodel.LoginViewModel
import com.example.openmusic.presentation.screens.LoginScreen

@Composable
fun LoginRoute(

    onLoginSuccess: () -> Unit,

    viewModel: LoginViewModel = hiltViewModel()

) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreen(

        state = state,

        onEvent = viewModel::onEvent

    )

}