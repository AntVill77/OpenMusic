package com.example.openmusic.domain.usecase

import com.example.openmusic.data.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(

    private val repository: AuthRepository

) {

    operator fun invoke() =
        repository.currentUser()

}