package com.example.modulotech_test.views.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.Heater
import com.example.modulotech_test.models.Light
import com.example.modulotech_test.models.RollerShutter

class HomeViewModel : ViewModel() {
    var listOfAllDevices = MutableLiveData<ArrayList<Device>>()
    var allList = arrayListOf<Device>()
    var lst = MutableLiveData<ArrayList<Device>>()
    var newList = arrayListOf<Device>()
    var filterLight = MutableLiveData<Boolean>(true)
    var filterHeater = MutableLiveData<Boolean>(true)
    var filterRollerShutter = MutableLiveData<Boolean>(true)

    fun init(devices: ArrayList<Device>){
        newList.clear()
        newList.addAll(devices)
        allList.clear()
        allList.addAll(devices)
        lst.value=newList
        listOfAllDevices.value = newList
    }

    fun remove(device: Device){
        newList.remove(device)
        lst.value = newList
        allList.remove(device)
        listOfAllDevices.value = allList
    }

    fun applyFilterLight(mode: Boolean){
        if(filterLight.value != mode){
            filterLight.value = mode
            updateList()
        }
    }

    fun applyFilterHeater(mode: Boolean){
        if(filterHeater.value != mode){
            filterHeater.value = mode
            updateList()
        }
    }
    fun applyFilterRollerShutter(mode: Boolean){
        if(filterRollerShutter.value != mode){
            filterRollerShutter.value = mode
            updateList()
        }
    }

    fun updateList(){
        newList.clear()
        allList.forEach { device ->
            when (device) {
                is Heater -> {
                    if (filterHeater.value == true)
                        newList.add(device)
                }
                is Light -> {
                    if (filterLight.value == true)
                        newList.add(device)
                }
                is RollerShutter -> {
                    if (filterRollerShutter.value == true)
                        newList.add(device)
                }
            }
        }
        lst.value = newList
    }

}