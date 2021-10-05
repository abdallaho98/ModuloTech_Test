package com.example.modulotech_test.models

import com.google.gson.JsonObject
import org.json.JSONObject
import java.io.Serializable

class Heater(
        id: String,
        deviceName: String,
        var temperature: Int,
        var mode: Boolean
) : Device(id, deviceName), Serializable{
        val productType = ProductType.Heater
        companion object {
                fun fromJSON(string: String): Heater {
                        val json = JSONObject(string)
                        return Heater(
                                json.getString("id"),
                                json.getString("deviceName"),
                                json.getInt("temperature"),
                                json.getString("mode") == "ON"
                        )
                }
        }
}