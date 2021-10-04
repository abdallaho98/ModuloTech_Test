package com.example.modulotech_test.models

import com.google.gson.JsonObject

class User(
        val firstName: String,
        val lastName: String,
        val address: Address,
        val birthDate: Long
){
        companion object {
                fun fromJSON(json: JsonObject): User {
                        return User(
                                json.get("firstName").asString,
                                json.get("lastName").asString,
                                Address.fromJSON(json.getAsJsonObject("address")),
                                json.get("birthDate").asLong
                        )
                }
        }
}