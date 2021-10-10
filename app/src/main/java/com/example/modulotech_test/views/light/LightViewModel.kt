package com.example.modulotech_test.views.light

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Light

class LightViewModel : ViewModel() {

    var light = MutableLiveData<Light>()
    var intensity = MutableLiveData<Int>()
    var mode = MutableLiveData<Boolean>()

    fun setLight(light : Light){
        this.light.value = light
        this.intensity.value = light.intensity
        this.mode.value = light.mode
    }

}