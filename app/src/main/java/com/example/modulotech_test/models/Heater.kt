package com.example.modulotech_test.models

import com.google.gson.JsonObject

class Heater(
        id: String,
        deviceName: String,
        var temperature: Int,
        var mode: Boolean
) : Device(id, deviceName) {
        companion object {
                fun fromJSON(json: JsonObject): Heater {
                        return Heater(
                                json.get("id").asString,
                                json.get("deviceName").asString,
                                json.get("temperature").asInt,
                                json.get("mode").asString == "ON"
                        )
                }
        }
}