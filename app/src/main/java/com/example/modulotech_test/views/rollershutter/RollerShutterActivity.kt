package com.example.modulotech_test.views.rollershutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modulotech_test.R
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.Heater
import com.example.modulotech_test.models.RollerShutter

class RollerShutterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roller_shutter)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val prefsHelp = AppPreferencesHelper(this, "data")
        val device = prefsHelp.getDevices().find {
            it.id == intent.getStringExtra("device")
        } as RollerShutter
        title = device?.deviceName
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}