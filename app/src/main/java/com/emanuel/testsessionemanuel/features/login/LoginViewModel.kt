package com.emanuel.testsessionemanuel.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emanuel.domine.usecase.ProductUseCase
import com.emanuel.testsessionemanuel.util.EMPTY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.LoginModel


class LoginViewModel(
    private val productUseCase: ProductUseCase
) : ViewModel() {
    private val _dni = MutableLiveData(String.EMPTY)
    fun getDni() = _dni

    private val _password = MutableLiveData(String.EMPTY)
    fun getPassword() = _password

    private val _enableButton = MutableLiveData<Boolean>(false)
    val enableButton: LiveData<Boolean>
        get() = _enableButton

    val userLogged = MutableLiveData<LoginModel>()

    val changeFields = MediatorLiveData<Boolean>().apply {
        addSource(_dni) { value = true }
        addSource(_password) { value = true }
    }

    fun getUser() {
        viewModelScope.launch {
            productUseCase.Login(_dni.value ?: String.EMPTY, _password.value ?: String.EMPTY).also {
                viewModelScope.launch(Dispatchers.Main){
                    userLogged.value = it
                }
            }
        }

    }

    fun habilitateBoton() {
        _enableButton.postValue(
            _dni.value?.isNotBlank() == true
                    &&
                    _password.value?.isNotBlank() == true
        )
    }

    fun finalizeEventChangeFields() = changeFields.postValue(false)
    fun enabledBtn(): Boolean {
        return true
    }
}