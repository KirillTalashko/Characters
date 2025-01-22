package com.example.characters.domain.repository

import com.example.characters.data.RetrofitClient
import com.example.characters.data.model.Characters
import retrofit2.Response

class CharacterRepositoryImpl : CharacterRepository {
    override suspend fun getCharacterData(page: Int): Response<Characters> {
        return RetrofitClient().getClient().getCharacterData(page)
    }
}