package com.example.modulotech_test.views.rollershutter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.RollerShutter

class RollerShutterViewModel : ViewModel() {

    var rollerShutter = MutableLiveData<RollerShutter>()
    var position = MutableLiveData<Int>()

    fun setRollerShutter(rollerShutter : RollerShutter){
        this.rollerShutter.value = rollerShutter
        this.position.value = rollerShutter.position
    }

}