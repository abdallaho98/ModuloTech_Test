package com.example.modulotech_test.views.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modulotech_test.R
import com.example.modulotech_test.adapters.DevicesRecyclerAdapter
import com.example.modulotech_test.helpers.AppPreferencesHelper

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        var viewManager = LinearLayoutManager(activity)
        var mainrecycler = root.findViewById(R.id.devices_list) as RecyclerView
        mainrecycler.layoutManager = viewManager
        val prefsHelp =
            context?.applicationContext?.let {
                    it1 -> AppPreferencesHelper(it1, "data")
            }
        if (prefsHelp != null) {
            homeViewModel.load(prefsHelp.getDevices())
        };
        activity?.let {
            homeViewModel.lst.observe(it, Observer { it11 ->
                Log.i("data", it11.toString())
                mainrecycler.adapter =
                    context?.let { it1 -> DevicesRecyclerAdapter(homeViewModel, it11, it1) }
            })
        }
        return root
    }
}