package com.example.modulotech_test.models

import com.google.gson.JsonObject
import org.json.JSONObject
import java.io.Serializable

class RollerShutter(
        id: String,
        deviceName: String,
        var position: Int
) : Device(id, deviceName) , Serializable{
        val productType = ProductType.RollerShutter
        companion object {
                fun fromJSON(string: String): RollerShutter {
                        val json = JSONObject(string)
                        return RollerShutter(
                                json.getString("id"),
                                json.getString("deviceName"),
                                json.getInt("position")
                        )
                }
        }
}