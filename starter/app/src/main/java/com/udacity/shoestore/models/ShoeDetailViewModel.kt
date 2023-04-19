package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel(shoes: Array<Shoe>?) : ViewModel() {
    private val _listShoe: MutableLiveData<Array<Shoe>> = MutableLiveData()
    val shoe: LiveData<Array<Shoe>>
        get() = _listShoe

    private val _shoeData: Shoe = Shoe("Shoe A", 0.0, "Company A", "Description A")


    init {
        if (shoes != null) {
            _listShoe.value = shoes
        } else {
            _listShoe.value = emptyArray()
        }

    }

    fun setName(newName: String) {
        _shoeData.name = newName
    }

    fun setCompany(newCompany: String) {
        _shoeData.company = newCompany
    }

    fun setSize(newSize: String) {
        if (newSize != "") {
            _shoeData.size = newSize.toDouble()
        }

    }

    fun setDescription(newDescription: String) {
        _shoeData.description = newDescription
    }

    fun onSave() {
        _listShoe.value = _listShoe.value?.plus(_shoeData)
    }
}