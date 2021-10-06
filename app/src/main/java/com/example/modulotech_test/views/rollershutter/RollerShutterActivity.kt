package com.example.modulotech_test.views.rollershutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.ActivityRollerShutterBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper
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
        val device = prefsHelp.getDevices().find {
            it.id == intent.getStringExtra("device")
        } as RollerShutter
        title = device?.deviceName
        // set Up the View Model
        rollerShutterViewModel =
            ViewModelProvider(this).get(RollerShutterViewModel::class.java)
        rollerShutterViewModel.setRollerShutter(device)
        binding.viewmodel = rollerShutterViewModel
        binding.lifecycleOwner = this
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}