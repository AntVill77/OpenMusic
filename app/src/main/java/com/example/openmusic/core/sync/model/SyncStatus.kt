package com.example.openmusic.core.sync.model

sealed interface SyncStatus {

    data object Idle : SyncStatus

    data object Syncing : SyncStatus

    data object Success : SyncStatus

    data class Error(
        val message: String
    ) : SyncStatus
}