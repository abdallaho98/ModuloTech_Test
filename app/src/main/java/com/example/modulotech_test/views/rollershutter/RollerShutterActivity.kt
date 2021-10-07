package com.example.modulotech_test.views.rollershutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.ActivityRollerShutterBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.RollerShutter
import com.google.android.material.slider.Slider

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
        findViewById<Slider>(R.id.position).addOnChangeListener { _, value, _ ->
            run {
                // rollerShutterViewModel.setPosition(value.toInt());
            }
        }
        rollerShutterViewModel.rollerShutter.observe(this , Observer<RollerShutter> {
            /*
            device = it as RollerShutter
            // Log.e("Here details", it.position.toString())
            prefsHelp.setDevices(
                prefsHelp.getDevices().map { it2 ->
                    if(it2.id == it.id) return@map device
                    return@map it2
                } as ArrayList<Device>
            )
             */
        })
        rollerShutterViewModel.position.observe(this, Observer<Integer> {
            Log.e("Here details 2", it.toString())
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}