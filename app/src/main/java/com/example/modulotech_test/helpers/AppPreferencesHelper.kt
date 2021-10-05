package com.example.modulotech_test.helpers
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.modulotech_test.models.*
import com.google.gson.Gson
import org.json.JSONArray


class AppPreferencesHelper(context: Context, prefFileName: String?) :
    PreferencesHelper {

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_KEY_USER = "PREF_KEY_USER"
        private const val PREF_KEY_DEVICES = "PREF_KEY_DEVICES"
    }

    override fun getUser(): User? {
        return if (mPrefs.getString(PREF_KEY_USER, null) != null) {
            User.fromJSON(
                mPrefs.getString(PREF_KEY_USER, null).toString()
            )
        } else null
    }

    override fun setUser(user: User?) {
        mPrefs.edit().putString(PREF_KEY_USER, Gson().toJson(user))
            .apply()
    }

    override fun getDevices(): ArrayList<Device> {
        val devicesString = JSONArray(mPrefs.getString(PREF_KEY_DEVICES, null))
        var devices : ArrayList<Device> = ArrayList()
        for(i in 0 until devicesString.length()){
            val device = devicesString.getJSONObject(i)
            when (device.getString("productType")) {
                "Heater" -> {
                    devices.add(Heater.fromJSON(device.toString()));
                }
                "Light" -> {
                    devices.add(Light.fromJSON(device.toString()));
                }
                "RollerShutter" -> {
                    devices.add(RollerShutter.fromJSON(device.toString()));
                }
            }
        }
        return devices
    }

    override fun setDevices(devices: ArrayList<Device>) {
        mPrefs.edit()
            .putString(PREF_KEY_DEVICES, Gson().toJson(devices))
            .apply()
    }
}