package com.example.modulotech_test.views.ui.account

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.FragmentAccountBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper
import com.example.modulotech_test.models.User
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)

        val prefsHelp = context?.applicationContext?.let { it1 ->
            AppPreferencesHelper(it1, "data")
        }

        if (prefsHelp?.getUser() != null) {
            accountViewModel.setUser(prefsHelp.getUser()!!)
        }

        val root: FragmentAccountBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_account, container, false
            )
        root.viewmodel = accountViewModel
        root.lifecycleOwner = viewLifecycleOwner
        accountViewModel.user.observe(viewLifecycleOwner, Observer<User> {
            prefsHelp?.setUser(it)
        })
        // Setting Message Errors EditTexts
        accountViewModel.isFirstNameValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.first_name_area).error =
                    getString(R.string.emptyField)
            }
        })
        accountViewModel.isLastNameValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.last_name_area).error =
                    getString(R.string.emptyField)
            }
        })
        accountViewModel.isBirthDateValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.birth_date_area).error =
                    getString(R.string.dateError)
            }
        })
        accountViewModel.isCityValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.city_area).error =
                    getString(R.string.emptyField)
            }
        })
        accountViewModel.isPostalCodeValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.postal_code_area).error =
                    getString(R.string.postalCodeError)
            }
        })
        accountViewModel.isStreetValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.street_area).error =
                    getString(R.string.emptyField)
            }
        })
        accountViewModel.isStreetCodeValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.street_code_area).error =
                    getString(R.string.emptyField)
            }
        })
        accountViewModel.isCountryValid.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it == false) {
                root.root.findViewById<TextInputLayout>(R.id.country_area).error =
                    getString(R.string.countryError)
            }
        })

        return root.root
    }
}