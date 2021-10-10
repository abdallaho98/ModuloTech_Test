package com.example.modulotech_test.views.light

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.ActivityLightBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.Light

class LightActivity : AppCompatActivity() {

    private lateinit var lightViewModel: LightViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLightBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_light)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // get Data From Extras
        val prefsHelp = AppPreferencesHelper(this, "data")
        val device = prefsHelp.getDevices().find {
            it.id == intent.getStringExtra("device")
        } as Light
        title = device?.deviceName
        // set Up the View Model
        lightViewModel =
            ViewModelProvider(this).get(LightViewModel::class.java)
        lightViewModel.setLight(device)
        binding.viewmodel = lightViewModel
        binding.lifecycleOwner = this
        // Observables
        lightViewModel.mode.observe(this, Observer<Boolean> {
            device.mode = it
            prefsHelp.setDevices(
                    prefsHelp.getDevices().map { item ->
                        if (item.id == device.id)
                            return@map device
                        return@map item
                    } as ArrayList<Device>
            )
        })

        lightViewModel.intensity.observe(this, Observer<Int> {
            device.intensity = it
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