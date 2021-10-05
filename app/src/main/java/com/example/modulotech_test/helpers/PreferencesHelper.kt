package com.example.modulotech_test.helpers

import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.User

interface PreferencesHelper {
    fun getUser(): User?
    fun setUser(user: User?)

    fun getDevices(): ArrayList<Device>?
    fun setDevices(devices: ArrayList<Device> )
}