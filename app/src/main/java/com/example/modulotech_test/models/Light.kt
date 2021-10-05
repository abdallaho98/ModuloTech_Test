package com.example.modulotech_test.models

import org.json.JSONObject
import java.io.Serializable

class Light(
        id: String,
        deviceName: String,
        var intensity: Int,
        var mode: Boolean
) : Device(id, deviceName), Serializable{
        val productType = ProductType.Light
        companion object {
                fun fromJSON(string: String): Light {
                        val json = JSONObject(string)
                        return Light(
                                json.getString("id"),
                                json.getString("deviceName"),
                                json.getInt("intensity"),
                                json.getString("mode") == "ON"
                        )
                }
        }
}