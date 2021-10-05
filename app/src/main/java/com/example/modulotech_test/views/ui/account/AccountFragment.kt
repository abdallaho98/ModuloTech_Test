package com.example.modulotech_test.views.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.FragmentAccountBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper

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
        root.lifecycleOwner = this
        return root.root
    }
}