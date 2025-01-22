package com.example.characters.data


import com.example.characters.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacterData(
        @Query("page") page: Int,
    ): Response<Characters>
}