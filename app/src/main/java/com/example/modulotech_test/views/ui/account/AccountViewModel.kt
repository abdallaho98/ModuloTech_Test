package com.example.modulotech_test.views.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Address
import com.example.modulotech_test.models.User

class AccountViewModel : ViewModel() {

    var user = MutableLiveData<User>()
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var birthDate = MutableLiveData<String>()
    var city = MutableLiveData<String>()
    var postalCode = MutableLiveData<Integer>()
    var street = MutableLiveData<String>()
    var streetCode = MutableLiveData<String>()
    var country = MutableLiveData<String>()

    fun getFirstNameText(): String{
        return firstName.value.toString()
    }

    fun setFirstNameText(firstName: String){
        if(this.firstName.value != firstName){
            this.firstName.value = firstName
        }
    }

    fun getLastNameText(): String{
        return lastName.value.toString()
    }

    fun setLastNameText(lastName: String){
        if(this.lastName.value != lastName){
            this.lastName.value = lastName
        }
    }

    fun getBirthDateText(): String{
        return birthDate.value.toString()
    }

    fun setBirthDateText(birthDate: String){
        if(this.birthDate.value != birthDate){
            this.birthDate.value = birthDate
        }
    }

    fun getCityText(): String{
        return city.value.toString()
    }

    fun setCityText(city: String){
        if(this.city.value != city){
            this.city.value = city
        }
    }

    fun getPostalCodeText(): Integer? {
        return postalCode.value
    }

    fun setPostalCodeText(postalCode: Integer){
        if(this.postalCode.value != postalCode){
            this.postalCode.value = postalCode
        }
    }

    fun getStreetText(): String{
        return street.value.toString()
    }

    fun setStreetText(street: String){
        if(this.street.value != street){
            this.street.value = street
        }
    }

    fun getStreetCodeText(): String{
        return streetCode.value.toString()
    }

    fun setStreetCodeText(streetCode: String){
        if(this.streetCode.value != streetCode){
            this.streetCode.value = streetCode
        }
    }

    fun getCountryText(): String{
        return country.value.toString()
    }

    fun setCountryText(country: String){
        if(this.country.value != country){
            this.country.value = country
        }
    }

    fun setUser(user : User){
        this.user.value = user
        this.firstName.value = user.firstName
        this.lastName.value = user.lastName
        this.birthDate.value = user.birthDate
        this.city.value = user.address.city
        this.postalCode.value = user.address.postalCode as Integer
        this.street.value = user.address.street
        this.streetCode.value = user.address.streetCode
        this.country.value = user.address.country
    }

    fun onClick(){
        this.user.value = User(
                this.firstName.value.toString(),
                this.lastName.value.toString(),
                Address(
                    this.city.value.toString(),
                    this.postalCode.value!!.toInt(),
                    this.street.value.toString(),
                    this.streetCode.value.toString(),
                    this.country.value.toString()
                ),
                this.birthDate.value.toString()
        )

    }

}