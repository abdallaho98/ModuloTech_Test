package com.example.modulotech_test.views.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modulotech_test.R
import com.example.modulotech_test.databinding.FragmentAccountBinding
import com.example.modulotech_test.databinding.FragmentDashboardBinding
import com.example.modulotech_test.helpers.AppPreferencesHelper

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root: FragmentDashboardBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_dashboard, container, false
            )
        root.viewmodel = dashboardViewModel
        root.lifecycleOwner = viewLifecycleOwner
        val textView: TextView = root.root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val prefsHelp = context?.let { AppPreferencesHelper(it, "data") }
        if (prefsHelp != null) {
            dashboardViewModel.init(prefsHelp.getDevices().size)
        }
        return root.root
    }
}