package com.example.modulotech_test.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.modulotech_test.R
import com.example.modulotech_test.models.Device
import com.example.modulotech_test.views.ui.home.HomeViewModel

class DevicesRecyclerAdapter(
    val viewModel: HomeViewModel,
    val arrayList: ArrayList<Device>,
    private val context: Context
): RecyclerView.Adapter<DevicesRecyclerAdapter.DeviceViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DevicesRecyclerAdapter.DeviceViewHolder {
        var root = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_device_item,parent,false)
        return DeviceViewHolder(root)
    }

    override fun onBindViewHolder(holder: DevicesRecyclerAdapter.DeviceViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }


    inner  class DeviceViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(device: Device){
            binding.findViewById<TextView>(R.id.title).text = device.deviceName
            binding.findViewById<ImageButton>(R.id.delete).setOnClickListener {
                viewModel.remove(device)
                notifyItemRemoved(arrayList.indexOf(device))
            }
        }

    }

}