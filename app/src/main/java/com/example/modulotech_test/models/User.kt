package com.example.modulotech_test.models

import org.json.JSONObject
import java.io.Serializable

class User(
        val firstName: String,
        val lastName: String,
        val address: Address,
        val birthDate: Long
): Serializable{
        companion object {
                fun fromJSON(string: String): User {
                        val json = JSONObject(string)
                        return User(
                                json.getString("firstName"),
                                json.getString("lastName"),
                                Address.fromJSON(json.getJSONObject("address").toString()),
                                json.getLong("birthDate")
                        )
                }
        }
}