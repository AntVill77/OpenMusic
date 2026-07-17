package com.example.openmusic.feature.player.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.openmusic.feature.player.presentation.PlayerEvent
import com.example.openmusic.feature.player.presentation.PlayerViewModel

@Composable
fun MiniPlayer(
    onClick:()->Unit,
    viewModel: PlayerViewModel = hiltViewModel()

){
    val state by viewModel.state.collectAsStateWithLifecycle()

    if(state.songId==null)
        return

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .clickable{

                onClick()
            }

    ){
        Column(
            //modifier = Modifier.weight(1f)
        ) {
            Row(

                modifier =
                    Modifier.padding(12.dp),

                verticalAlignment =
                    Alignment.CenterVertically

            ) {
                AsyncImage(

                    model = state.artwork,
                   // model = "",

                    modifier =
                        Modifier.size(56.dp),

                    contentDescription = null

                )
                Text(

                    text = state.title,
                    //text = "title",

                    maxLines = 1

                )
            }
            Text(

                //text = "artist",
                text = state.artist,

                maxLines = 1

            )


            IconButton(
                    //onClick = {}

                    onClick = {

                    if(state.playing)

                        viewModel.onEvent(

                            PlayerEvent.Pause

                        )

                    else

                        viewModel.onEvent(

                            PlayerEvent.Resume

                        )

                }

                ) {

                }



        }
        LinearProgressIndicator(

            progress = {

                  if(state.duration==0L)

                0f

            else

                state.currentPosition
                    .toFloat()/

                        state.duration

            },

            modifier =
                Modifier.fillMaxWidth()

        )

    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun MiniPlayerPreview(){
   MiniPlayer()
}*/
