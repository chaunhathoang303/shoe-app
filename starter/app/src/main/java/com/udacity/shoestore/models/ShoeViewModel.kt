package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel() : ViewModel() {
    private val _listShoe: MutableLiveData<Array<Shoe>> = MutableLiveData()
    val listShoe: LiveData<Array<Shoe>>
        get() = _listShoe

    var shoeData: Shoe = Shoe("", 0.0, "", "")
    var size = ""

    init {
        _listShoe.value = emptyArray()
    }

    fun addShoe() {
        if (size != null) {
            shoeData.size = size.toDouble()
        }
        _listShoe.value = (_listShoe.value)?.plus(shoeData)
        shoeData = Shoe("", 0.0, "", "")
        size = ""
    }


}