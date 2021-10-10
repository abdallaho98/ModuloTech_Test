package com.example.modulotech_test.views.heater

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Heater

class HeaterViewModel : ViewModel() {

    var heater = MutableLiveData<Heater>()
    var temperature = MutableLiveData<Int>()
    var mode = MutableLiveData<Boolean>()

    fun setHeater(heater : Heater){
        this.heater.value = heater
        this.temperature.value = heater.temperature
        this.mode.value = heater.mode
    }

}