package com.example.modulotech_test.views.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.models.User

class AccountViewModel : ViewModel() {

    var user = MutableLiveData<User>()

}