package com.example.modulotech_test.views.heater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.ActivityHeaterBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.Heater

class HeaterActivity : AppCompatActivity() {

    private lateinit var heaterViewModel: HeaterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHeaterBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_heater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // get Data From Extras
        val prefsHelp = AppPreferencesHelper(this, "data")
        val device = prefsHelp.getDevices().find {
            it.id == intent.getStringExtra("device")
        } as Heater
        title = device?.deviceName
        // set Up the View Model
        heaterViewModel =
            ViewModelProvider(this).get(HeaterViewModel::class.java)
        heaterViewModel.setHeater(device)
        binding.viewmodel = heaterViewModel
        binding.lifecycleOwner = this
        // Observables
        heaterViewModel.mode.observe(this, Observer<Boolean> {
            device.mode = it
            prefsHelp.setDevices(
                    prefsHelp.getDevices().map { item ->
                        if (item.id == device.id)
                            return@map device
                        return@map item
                    } as ArrayList<Device>
            )
        })

        heaterViewModel.temperature.observe(this, Observer<Int> {
            device.temperature = it
            prefsHelp.setDevices(
                    prefsHelp.getDevices().map { item ->
                        if (item.id == device.id)
                            return@map device
                        return@map item
                    } as ArrayList<Device>
            )
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}