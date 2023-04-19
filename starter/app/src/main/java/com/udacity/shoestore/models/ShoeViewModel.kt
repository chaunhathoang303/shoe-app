package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel(shoes: Array<Shoe>?) : ViewModel() {
    private val _listShoe: MutableLiveData<Array<Shoe>> = MutableLiveData()
    val listShoe: LiveData<Array<Shoe>>
        get() = _listShoe

    init {
        _listShoe.value = emptyArray()
        if (shoes != null) {
            _listShoe.value = shoes
        }
    }
}