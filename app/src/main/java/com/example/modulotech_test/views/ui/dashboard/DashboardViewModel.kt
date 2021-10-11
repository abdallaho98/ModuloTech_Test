package com.example.modulotech_test.views.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You have "
    }
    val text: LiveData<String> = _text

    val numberDevices = MutableLiveData<Int>()

    fun init(nbr : Int){
        numberDevices.value = nbr
    }
}