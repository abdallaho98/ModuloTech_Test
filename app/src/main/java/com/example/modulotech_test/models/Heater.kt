package com.example.modulotech_test.models

class Heater(
        id: String,
        deviceName: String,
        var temperature: Int,
        var mode: Boolean
) : Device(id, deviceName) {
}