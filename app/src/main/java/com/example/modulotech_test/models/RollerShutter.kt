package com.example.modulotech_test.models

import com.google.gson.JsonObject

class RollerShutter(
        id: String,
        deviceName: String,
        var position: Int
) : Device(id, deviceName) {
        companion object {
                fun fromJSON(json: JsonObject): RollerShutter {
                        return RollerShutter(
                                json.get("id").asString,
                                json.get("deviceName").asString,
                                json.get("position").asInt
                        )
                }
        }
}