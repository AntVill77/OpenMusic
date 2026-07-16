package com.example.openmusic.core.network.firebase

import com.example.openmusic.domain.model.SongDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.jvm.java

class SongFirestoreServiceImpl @Inject constructor(

    private val firestore: FirebaseFirestore

) : SongFirestoreService {

    override suspend fun getSongs(): List<SongDto> {

        return firestore
            .collection("songs")
            .get()
            .await()
            .documents
            .mapNotNull {

                it.toObject(SongDto::class.java)

            }

    }

}