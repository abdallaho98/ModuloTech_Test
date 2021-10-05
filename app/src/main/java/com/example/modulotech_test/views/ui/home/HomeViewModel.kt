package com.example.modulotech_test.views.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Device

class HomeViewModel : ViewModel() {
    var lst = MutableLiveData<ArrayList<Device>>()
    var newlist = arrayListOf<Device>()

    fun load(devices: ArrayList<Device>){
        newlist.clear()
        newlist.addAll(devices)
        lst.value=newlist
    }

    fun remove(device: Device){
        newlist.remove(device)
        lst.value=newlist
    }

}