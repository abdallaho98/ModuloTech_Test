package com.example.modulotech_test.views.light

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Light

class LightViewModel : ViewModel() {

    var light = MutableLiveData<Light>()

    fun setLight(light : Light){
        this.light.value = light
    }

}