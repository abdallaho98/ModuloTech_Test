package com.example.modulotech_test.models

import org.json.JSONObject
import java.io.Serializable

class Address (
        var city: String,
        var postalCode: Int,
        var street: String,
        var streetCode: String,
        var country: String
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

        override fun equals(other: Any?): Boolean {
                if (other is Address) {
                        if (city != other.city) return false
                        if (postalCode != other.postalCode) return false
                        if (street != other.street) return false
                        if (streetCode != other.streetCode) return false
                        if (country != other.country) return false
                        return true
                }
                return false
        }

        override fun hashCode(): Int {
                var result = city.hashCode()
                result = 31 * result + postalCode
                result = 31 * result + street.hashCode()
                result = 31 * result + streetCode.hashCode()
                result = 31 * result + country.hashCode()
                return result
        }

        override fun toString(): String {
                return "Address(city='$city', postalCode=$postalCode, street='$street', streetCode='$streetCode', country='$country')"
        }
}