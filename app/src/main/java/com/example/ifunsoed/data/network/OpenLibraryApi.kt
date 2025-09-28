package com.example.ifunsoed.data.network

import android.content.Intent
import com.example.ifunsoed.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {

    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit : Int
    ): Response<SearchResponse>
}