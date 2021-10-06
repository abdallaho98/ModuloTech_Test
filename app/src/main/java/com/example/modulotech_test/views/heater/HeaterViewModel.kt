package com.example.modulotech_test.views.heater

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Heater

class HeaterViewModel : ViewModel() {

    var heater = MutableLiveData<Heater>()

    fun setHeater(heater : Heater){
        this.heater.value = heater
    }

}