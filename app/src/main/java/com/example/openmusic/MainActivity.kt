package com.example.openmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.openmusic.app.AppScaffold
import com.example.openmusic.ui.theme.OpenMusicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenMusicTheme {
                //val navController = rememberNavController()

                //AppNavHost(navController)
                AppScaffold()
            }
        }
    }
}
