package com.example.modulotech_test.views.rollershutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.ActivityRollerShutterBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.RollerShutter

class RollerShutterActivity : AppCompatActivity() {

    private lateinit var rollerShutterViewModel: RollerShutterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRollerShutterBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_roller_shutter)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // get Data From Extras
        val prefsHelp = AppPreferencesHelper(this, "data")
        var device = prefsHelp.getDevices().find {
            it.id == intent.getStringExtra("device")
        } as RollerShutter
        title = device?.deviceName
        // set Up the View Model
        rollerShutterViewModel =
            ViewModelProvider(this).get(RollerShutterViewModel::class.java)
        rollerShutterViewModel.setRollerShutter(device)
        binding.viewmodel = rollerShutterViewModel
        binding.lifecycleOwner = this
        // Observables
        rollerShutterViewModel.rollerShutter.observe(this , Observer {
            device = it
            Log.e("Here details", it.position.toString())
            prefsHelp.setDevices(
                prefsHelp.getDevices().map { it2 ->
                    if(it2.id == device.id) return@map device
                    return@map it2
                } as ArrayList<Device>
            )
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}