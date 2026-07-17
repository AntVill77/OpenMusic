package com.example.openmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.openmusic.presentation.screens.HomeScreen
import com.example.openmusic.domain.viewmodel.HomeViewModel
import com.example.openmusic.navigation.AppNavHost
import com.example.openmusic.ui.theme.OpenMusicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenMusicTheme {
                val navController = rememberNavController()

                AppNavHost(navController)
            }
        }
    }
}
