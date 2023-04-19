package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _eventLogin: MutableLiveData<Boolean> = MutableLiveData()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private var _userName: String = ""
    private var _password: String = ""

    init {
        _eventLogin.value = false
    }

    fun getUserName(userName: String) {
        _userName = userName
    }

    fun getPassword(password: String) {
        _password = password
    }

    fun onLogin() {
        _eventLogin.value = _userName == "abc@gmail.com" && _password == "123456"
    }
}