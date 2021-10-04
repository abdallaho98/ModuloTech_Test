package com.example.modulotech_test.models

import com.google.gson.JsonObject

class Address (
        val city: String,
        val postalCode: Int,
        val street: String,
        val streetCode: String,
        val country: String
){
        companion object {
                fun fromJSON(json: JsonObject): Address {
                        return Address(
                                json.get("city").asString,
                                json.get("postalCode").asInt,
                                json.get("street").asString,
                                json.get("streetCode").asString,
                                json.get("country").asString
                        )
                }
        }
}