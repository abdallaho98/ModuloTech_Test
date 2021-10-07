package com.example.modulotech_test.models

import org.json.JSONObject
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class User(
        var firstName: String,
        var lastName: String,
        var address: Address,
        var birthDate: String
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

        override fun equals(other: Any?): Boolean {
                if (other is User) {
                        if (this.firstName != other.firstName) return false
                        if (this.lastName != other.lastName) return false
                        if (this.address != other.address) return false
                        if (this.birthDate != other.birthDate) return false
                        return true
                }
                return false
        }

        override fun hashCode(): Int {
                return (firstName + lastName).hashCode()
        }

        override fun toString(): String {
                return "User(firstName='$firstName', lastName='$lastName', address=$address, birthDate='$birthDate')"
        }
}