package com.example.modulotech_test.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.slider.Slider

@BindingAdapter("position")
fun setPosition(view: Slider, newValue: Int) {
    if (view.value.toInt() != newValue) {
        view.value = newValue.toFloat()
    }
}

@BindingAdapter("app:positionAttrChanged")
fun setListeners(
    view: Slider,
    attrChange: InverseBindingListener
) {
    view.addOnChangeListener { _, _, _ ->
        attrChange.onChange()
    }
}

@InverseBindingAdapter(attribute = "position")
fun getPosition(view: Slider) : Int {
    return view.value.toInt()
}