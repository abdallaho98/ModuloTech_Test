package com.example.modulotech_test.api

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface APIService {
    @GET("/modulotest/data.json")
    fun getData(): Call<JsonObject>
}