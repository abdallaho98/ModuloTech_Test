package com.example.modulotech_test.views.heater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modulotech_test.R
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.Heater

class HeaterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val prefsHelp = AppPreferencesHelper(this, "data")
        val device = prefsHelp.getDevices().find {
            it.id == intent.getStringExtra("device")
        } as Heater
        title = device?.deviceName
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}