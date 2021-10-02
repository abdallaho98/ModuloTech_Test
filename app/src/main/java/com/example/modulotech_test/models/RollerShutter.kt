package com.example.modulotech_test.models

class RollerShutter(
        id: String,
        deviceName: String,
        var position: Int
) : Device(id, deviceName) {
}