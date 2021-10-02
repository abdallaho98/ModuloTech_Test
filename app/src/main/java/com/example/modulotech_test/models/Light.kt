package com.example.modulotech_test.models

class Light(
        id: String,
        deviceName: String,
        var intensity: Int,
        var mode: Boolean
) : Device(id, deviceName) {
}