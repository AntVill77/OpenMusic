package com.example.openmusic.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.openmusic.presentation.login.LoginEvent
import com.example.openmusic.presentation.login.LoginState

@Composable
fun LoginScreen(

    state: LoginState,

    onEvent: (LoginEvent) -> Unit

) {
    Box(

        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center

    ) {
        Text("Login")
        // UI solamente
    }

}