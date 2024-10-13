package com.cibertec.myciberapps05

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("getTags")
    fun getAllTags(): Call<List<Tag>>

    @GET("getPriorities")
    fun getAllPriorities(): Call<List<Priority>>

}