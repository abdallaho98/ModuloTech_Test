package com.example.modulotech_test.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

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