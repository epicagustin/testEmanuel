package com.emanuel.data.repository

import com.emanuel.data.model.LoginRequestBody
import com.emanuel.data.model.LoginResponse
import com.emanuel.data.model.ProductResponse
import com.emanuel.data.remote.LoginServiceClient

class ProductsRepository(private val api: LoginServiceClient) {
    suspend fun login(user: LoginRequestBody): LoginResponse {
        return api.loginDni(user)
    }
    suspend fun getProducts(): List<ProductResponse>{
        return api.getProducts()
    }
}