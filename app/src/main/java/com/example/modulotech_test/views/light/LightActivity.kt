package com.example.modulotech_test.views.light

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modulotech_test.R

class LightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        finish()
    }
}