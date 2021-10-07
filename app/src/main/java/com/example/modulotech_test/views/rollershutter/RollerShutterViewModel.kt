package com.example.modulotech_test.views.rollershutter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.RollerShutter

class RollerShutterViewModel : ViewModel() {

    var rollerShutter = MutableLiveData<RollerShutter>()
    var position = MutableLiveData<Integer>()

    fun setRollerShutter(rollerShutter : RollerShutter){
        this.rollerShutter.value = rollerShutter
        this.position.value = rollerShutter.position as Integer
    }

    fun getPositionL(): Integer{
        return this.position.value!!
    }

    fun setPositionL(position: Integer){
        if (this.rollerShutter.value?.position != position.toInt()) {
            this.rollerShutter.value?.position = position.toInt()
            this.position.value = position
        }
    }

}