package com.example.modulotech_test.utils

import android.icu.text.SimpleDateFormat
import java.text.ParseException
import java.util.*

class Validators{
    companion object {
        fun isNotEmpty(string: String) : Boolean {
            return string.trim().isNotEmpty()
        }

        fun isValidPostalCode(string: String) : Boolean {
            return string.trim().length == 5
        }

        fun isValidDate(inDate: String): Boolean {
            if(inDate.trim().length != 10) return false
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            dateFormat.isLenient = false
            try {
                dateFormat.parse(inDate.trim { it <= ' ' })
            } catch (pe: ParseException) {
                return false
            }
            return true
        }

        fun isValidCountry(country: String) : Boolean {
            val locales = Locale.getISOCountries()
            val countries = ArrayList<String>()
            for (countryCode in locales) {
                val obj = Locale("", countryCode)
                countries.add(obj.displayCountry.toLowerCase())
            }
            return countries.contains(country.toLowerCase())
        }

    }
}