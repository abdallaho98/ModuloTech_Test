package com.example.modulotech_test.models

import org.json.JSONObject
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class User(
        val firstName: String,
        val lastName: String,
        val address: Address,
        val birthDate: String
): Serializable{
        companion object {
                fun fromJSON(string: String): User {
                        val json = JSONObject(string)
                        var birthDate = ""
                        birthDate = if(json.get("birthDate") is Long){
                                val sdf = SimpleDateFormat("dd/MM/yyyy")
                                val netDate = Date(json.getLong("birthDate"))
                                sdf.format(netDate)
                        } else {
                                json.getString("birthDate")
                        }
                        return User(
                                json.getString("firstName"),
                                json.getString("lastName"),
                                Address.fromJSON(json.getJSONObject("address").toString()),
                                birthDate
                        )
                }
        }
}