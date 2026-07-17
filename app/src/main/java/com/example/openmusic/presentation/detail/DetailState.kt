package com.example.openmusic.presentation.detail

import com.example.openmusic.domain.model.Song

data class DetailState(

    val song: Song? = null,

    val loading:Boolean=false

)