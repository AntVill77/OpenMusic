package com.example.openmusic.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(

    viewModel: HomeViewModel =
        hiltViewModel()

) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(state)

}