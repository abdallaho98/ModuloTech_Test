package com.example.modulotech_test.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.modulotech_test.R
import com.example.modulotech_test.api.APIService
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.*
import com.google.gson.Gson
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
        val prefsHelp = AppPreferencesHelper(applicationContext, "data")

        if(prefsHelp.getUser() == null) {

            // Create Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Gson
            val gson = Gson()

            // Create Service
            val service = retrofit.create(APIService::class.java)
            service.getData().enqueue(object : Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {

                    if (response?.body() != null) {
                        Log.e("RETROFIT", "SUCCESS")
                        var devices: ArrayList<Device> = ArrayList()
                        for (device in response.body()!!.getAsJsonArray("devices")) {
                            when (device.asJsonObject.get("productType").asString) {
                                "Heater" -> {
                                    devices.add(Heater.fromJSON(gson.toJson(device)));
                                }
                                "Light" -> {
                                    devices.add(Light.fromJSON(gson.toJson(device)));
                                }
                                "RollerShutter" -> {
                                    devices.add(RollerShutter.fromJSON(gson.toJson(device)));
                                }
                            }
                        }
                        var user: User = User.fromJSON(
                            gson.toJson(response.body()!!.getAsJsonObject("user"))
                        )

                        // save data to shared Pref
                        prefsHelp.setUser(user)
                        prefsHelp.setDevices(devices)
                    }
                }

                override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                    Log.e("RETROFIT", t?.message.toString())
                }
            })
        } else {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}