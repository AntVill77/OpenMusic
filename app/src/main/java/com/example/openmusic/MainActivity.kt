package com.example.openmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.openmusic.presentation.home.HomeScreen
import com.example.openmusic.presentation.home.HomeViewModel
import com.example.openmusic.presentation.navigation.OpenMusicNavigation
import com.example.openmusic.ui.theme.OpenMusicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenMusicTheme {
                   // OpenMusicNavigation()
                val viewModel: HomeViewModel = hiltViewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()
                HomeScreen(state = state)
            }
        }
    }
}
