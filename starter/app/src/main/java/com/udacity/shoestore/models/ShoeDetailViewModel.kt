package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel(shoes: Array<Shoe>?) : ViewModel() {
    private val _listShoe: MutableLiveData<Array<Shoe>> = MutableLiveData()
    val shoe: LiveData<Array<Shoe>>
        get() = _listShoe

    val shoeData: Shoe = Shoe("", 0.0, "", "")
    val size: String = ""


    init {
        if (shoes != null) {
            _listShoe.value = shoes
        } else {
            _listShoe.value = emptyArray()
        }

    }

    fun onSave() {
        if (size != "") {
            shoeData.size = size.toDouble()
        }
        _listShoe.value = _listShoe.value?.plus(shoeData)
    }
}