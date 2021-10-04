package com.example.modulotech_test.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/modulotest/data.json")
    fun getData(): Call<JsonObject>
}