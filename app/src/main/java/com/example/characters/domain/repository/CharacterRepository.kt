package com.example.characters.domain.repository

import com.example.characters.data.model.Characters
import retrofit2.Response

interface CharacterRepository {

    suspend fun getCharacterData(page: Int): Response<Characters>
}