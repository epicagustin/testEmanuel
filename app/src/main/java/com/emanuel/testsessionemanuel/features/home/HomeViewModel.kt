package com.emanuel.testsessionemanuel.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emanuel.domine.usecase.ProductUseCase
import kotlinx.coroutines.launch
import models.ProductModel

class HomeViewModel(private val useCase: ProductUseCase) : ViewModel() {
    val products = MutableLiveData<List<ProductModel>>()
    fun getProducts() {
        viewModelScope.launch {
            useCase.getProducts().also {
                products.value = it
            }

        }

    }

}