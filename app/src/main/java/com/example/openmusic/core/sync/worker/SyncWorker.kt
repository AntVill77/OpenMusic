package com.example.openmusic.core.sync.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.openmusic.domain.usecase.SyncSongsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SyncWorker @AssistedInject constructor(

    @Assisted context: Context,

    @Assisted params: WorkerParameters,

    private val syncSongs: SyncSongsUseCase

) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        return try {

            syncSongs()

            Result.success()

        } catch (e: Exception) {

            Result.retry()

        }

    }

}