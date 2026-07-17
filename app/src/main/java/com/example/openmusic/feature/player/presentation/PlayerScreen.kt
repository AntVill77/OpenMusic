package com.example.openmusic.feature.player.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.openmusic.core.util.formatTime

@Composable
fun PlayerScreen(

    viewModel: PlayerViewModel = hiltViewModel()

) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {

        AsyncImage(

            model = state.artwork,

            contentDescription = null,

            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = state.title)

        Text(text = state.artist)

        Spacer(modifier = Modifier.height(20.dp))

        Slider(

            value = state.currentPosition.toFloat(),

            onValueChange = {

                viewModel.onEvent(

                    PlayerEvent.SeekTo(

                        it.toLong()

                    )

                )

            },

            valueRange = 0f..state.duration.toFloat().coerceAtLeast(1f)

        )

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(

                formatTime(

                    state.currentPosition

                )

            )

            Text(

                formatTime(

                    state.duration

                )

            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.Center

        ) {

            if (state.playing) {

                IconButton(

                    onClick = {

                        viewModel.onEvent(
                            PlayerEvent.Pause
                        )

                    }

                ) {

                    Icon(

                        Icons.Default.Pause,

                        contentDescription = null

                    )

                }

            } else {

                IconButton(

                    onClick = {

                        viewModel.onEvent(
                            PlayerEvent.Resume
                        )

                    }

                ) {

                    Icon(

                        Icons.Default.PlayArrow,

                        contentDescription = null

                    )

                }

            }

        }

    }

}