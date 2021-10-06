package com.example.modulotech_test.models

open abstract class Device (
        val id: String,
        val deviceName: String
){
        override fun equals(other: Any?): Boolean {
                if(other is Device) {
                        return other.id == this.id
                }
                return false
        }

        override fun hashCode(): Int {
                return id.hashCode()
        }
}