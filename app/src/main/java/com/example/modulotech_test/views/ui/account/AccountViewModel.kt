package com.example.modulotech_test.views.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modulotech_test.models.Address
import com.example.modulotech_test.models.User
import com.example.modulotech_test.utils.Validators


class AccountViewModel : ViewModel() {

    var user = MutableLiveData<User>()
    private var firstName = MutableLiveData<String>()
    private var lastName = MutableLiveData<String>()
    private var birthDate = MutableLiveData<String>()
    private var city = MutableLiveData<String>()
    private var postalCode = MutableLiveData<Integer>()
    private var street = MutableLiveData<String>()
    private var streetCode = MutableLiveData<String>()
    private var country = MutableLiveData<String>()
    // Validators
    var isFirstNameValid = MutableLiveData<Boolean>(true)
    var isLastNameValid = MutableLiveData<Boolean>(true)
    var isBirthDateValid = MutableLiveData<Boolean>(true)
    var isCityValid = MutableLiveData<Boolean>(true)
    var isPostalCodeValid = MutableLiveData<Boolean>(true)
    var isStreetValid = MutableLiveData<Boolean>(true)
    var isStreetCodeValid = MutableLiveData<Boolean>(true)
    var isCountryValid = MutableLiveData<Boolean>(true)
    var isFormValid = MutableLiveData<Boolean>(true)

    fun getFirstNameText(): String{
        return firstName.value.toString()
    }

    fun setFirstNameText(firstName: String){
        if(this.firstName.value != firstName){
            this.firstName.value = firstName
            this.isFirstNameValid.value = Validators.isNotEmpty(firstName)
            this.isFormValid.value = onValidate()
        }
    }

    fun getLastNameText(): String{
        return lastName.value.toString()
    }

    fun setLastNameText(lastName: String){
        if(this.lastName.value != lastName){
            this.lastName.value = lastName
            this.isLastNameValid.value = Validators.isNotEmpty(lastName)
            this.isFormValid.value = onValidate()
        }
    }

    fun getBirthDateText(): String{
        return birthDate.value.toString()
    }

    fun setBirthDateText(birthDate: String){
        if(this.birthDate.value != birthDate){
            this.birthDate.value = birthDate
            this.isBirthDateValid.value = Validators.isValidDate(birthDate)
            this.isFormValid.value = onValidate()
        }
    }

    fun getCityText(): String{
        return city.value.toString()
    }

    fun setCityText(city: String){
        if(this.city.value != city){
            this.city.value = city
            this.isCityValid.value = Validators.isNotEmpty(city)
            this.isFormValid.value = onValidate()
        }
    }

    fun getPostalCodeText(): Integer? {
        return postalCode.value
    }

    fun setPostalCodeText(postalCode: Integer){
        if(this.postalCode.value != postalCode){
            this.postalCode.value = postalCode
            this.isPostalCodeValid.value = Validators.isValidPostalCode(postalCode.toString())
            this.isFormValid.value = onValidate()
        }
    }

    fun getStreetText(): String{
        return street.value.toString()
    }

    fun setStreetText(street: String){
        if(this.street.value != street){
            this.street.value = street
            this.isStreetValid.value = Validators.isNotEmpty(street)
            this.isFormValid.value = onValidate()
        }
    }

    fun getStreetCodeText(): String{
        return streetCode.value.toString()
    }

    fun setStreetCodeText(streetCode: String){
        if(this.streetCode.value != streetCode){
            this.streetCode.value = streetCode
            this.isStreetCodeValid.value = Validators.isNotEmpty(streetCode)
            this.isFormValid.value = onValidate()
        }
    }

    fun getCountryText(): String{
        return country.value.toString()
    }

    fun setCountryText(country: String){
        if(this.country.value != country){
            this.country.value = country
            this.isCountryValid.value = Validators.isValidCountry(country)
            this.isFormValid.value = onValidate()
        }
    }

    fun setUser(user: User){
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

    private fun onValidate() : Boolean {
        return isFirstNameValid.value == true
                && isLastNameValid.value == true
                && isBirthDateValid.value == true
                && isCityValid.value == true
                && isCountryValid.value == true
                && isPostalCodeValid.value == true
                && isStreetCodeValid.value == true
                && isStreetValid.value == true
    }

    fun onClick(){
        if( onValidate() )
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