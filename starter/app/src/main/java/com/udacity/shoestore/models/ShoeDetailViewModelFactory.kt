package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShoeDetailViewModelFactory(private val shoes: Array<Shoe>?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeDetailViewModel::class.java)) {
            return ShoeDetailViewModel(shoes) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}