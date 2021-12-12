package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

enum class LoginState {
    LOGGED_IN, LOGGED_OUT, REGISTERED, LOGIN_ERROR
}

class LoginViewModel : ViewModel() {
    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState>
        get() = _loginState

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    init {
        _loginState.value = LoginState.LOGGED_OUT
        _email.value = ""
        _password.value = ""
    }

    fun onLogin(email: String, password: String) {
        _loginState.value = LoginState.LOGGED_IN
        _email.value = email
        _password.value = password
        Timber.i("User ${_email.value} has logged in successfully")
    }

    fun onRegister(email: String, password: String) {
        _loginState.value = LoginState.REGISTERED
        _email.value = email
        _password.value = password
        Timber.i("User ${_email.value} has registered in successfully")
    }

    fun onLoginError() {
        _loginState.value = LoginState.LOGIN_ERROR
        Timber.i("User ${_email.value} had a login error!")
    }
}