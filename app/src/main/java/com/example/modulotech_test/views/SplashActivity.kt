package com.example.modulotech_test.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.modulotech_test.R
import com.example.modulotech_test.api.APIService
import com.example.modulotech_test.models.*
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(getString(R.string.base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create Service
        val service = retrofit.create(APIService::class.java)
        service.getData().enqueue( object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {

                if(response?.body() != null){
                    Log.e("RETROFIT", response.body().toString())
                    var devices : ArrayList<Device> = ArrayList()
                    for(device in response.body()!!.getAsJsonArray("devices")){
                        when (device.asJsonObject.get("productType").asString) {
                            "Heater" -> {
                                devices.add(Heater.fromJSON(device.asJsonObject));
                            }
                            "Light" -> {
                                devices.add(Light.fromJSON(device.asJsonObject));
                            }
                            "RollerShutter" -> {
                                devices.add(RollerShutter.fromJSON(device.asJsonObject));
                            }
                        }
                    }
                    var user : User = User.fromJSON(response.body()!!.getAsJsonObject("user"))
                    Log.e("USER", user.firstName.toString())
                }
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                Log.e("RETROFIT", t?.message.toString())
            }
        })
    }
}