package com.example.modulotech_test.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import org.json.JSONObject
import java.io.Serializable
import java.util.*

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