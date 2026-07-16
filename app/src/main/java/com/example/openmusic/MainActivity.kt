package com.example.openmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.openmusic.presentation.navigation.OpenMusicNavigation
import com.example.openmusic.ui.theme.OpenMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenMusicTheme {

                    OpenMusicNavigation()
            }
        }
    }
}
