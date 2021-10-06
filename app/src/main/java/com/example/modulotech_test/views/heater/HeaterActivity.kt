package com.example.modulotech_test.views.heater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modulotech_test.R

class HeaterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        finish()
    }
}