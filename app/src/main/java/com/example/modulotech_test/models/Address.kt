package com.example.modulotech_test.models

import com.google.gson.JsonObject
import org.json.JSONObject
import java.io.Serializable

class Address (
        val city: String,
        val postalCode: Int,
        val street: String,
        val streetCode: String,
        val country: String
): Serializable {
        companion object {
                fun fromJSON(string: String): Address {
                        val json = JSONObject(string)
                        return Address(
                                json.getString("city"),
                                json.getInt("postalCode"),
                                json.getString("street"),
                                json.getString("streetCode"),
                                json.getString("country")
                        )
                }
        }
}