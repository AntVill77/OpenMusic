package com.example.openmusic.core.network.firebase

import com.example.openmusic.domain.model.SongDto

interface SongFirestoreService {

    suspend fun getSongs(): List<SongDto>

}