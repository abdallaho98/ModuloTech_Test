package com.example.modulotech_test.models

import com.google.gson.JsonObject

class Light(
        id: String,
        deviceName: String,
        var intensity: Int,
        var mode: Boolean
) : Device(id, deviceName) {
        companion object {
                fun fromJSON(json: JsonObject): Light {
                        return Light(
                                json.get("id").asString,
                                json.get("deviceName").asString,
                                json.get("intensity").asInt,
                                json.get("mode").asString == "ON"
                        )
                }
        }
}