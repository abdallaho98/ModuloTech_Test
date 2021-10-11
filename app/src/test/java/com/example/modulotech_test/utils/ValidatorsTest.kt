package com.example.modulotech_test.utils

import android.content.Context
import android.content.SharedPreferences
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito


@RunWith(JUnit4::class)
class ValidatorsTest{

    // Empty
    @Test
    fun whenInputIsEmpty(){
        assert(!Validators.isNotEmpty(""))
    }

    @Test
    fun whenDateIsEmpty(){
        assert(!Validators.isValidDate(""))
    }

    @Test
    fun whenPostalCodeIsEmpty(){
        assert(!Validators.isValidPostalCode(""))
    }

    @Test
    fun whenCountryIsEmpty(){
        assert(!Validators.isValidCountry(""))
    }

    // contain invalid input

    @Test
    fun whenInputInvalid(){
        assert(Validators.isNotEmpty("Hello World"))
    }

    @Test
    fun whenPostalCodeInvalid(){
        assert(!Validators.isValidPostalCode("989789"))
    }

    @Test
    fun whenCountryInvalid(){
        assert(!Validators.isValidCountry("FrancCC"))
    }

    // when valid input

    @Test
    fun whenPostalCodeValid(){
        assert(Validators.isValidPostalCode("75010"))
    }

    @Test
    fun whenCountryValid(){
        assert(Validators.isValidCountry("FRANCE"))
    }
}