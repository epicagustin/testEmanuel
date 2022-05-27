package com.emanuel.domine.usecase

import com.emanuel.data.model.LoginRequestBody
import com.emanuel.data.repository.ProductsRepository
import models.LoginModel
import models.ProductModel

class ProductUseCase(private val repository: ProductsRepository) {
    suspend fun Login(dni: String, password: String): LoginModel {
        val response = repository.login(user = LoginRequestBody(dni = dni, password = password))
        return LoginModel(
            accessToken = response.access_token,
            expiresIn = response.expires_in,
            products = response.products.map {
                ProductModel(detail = it.detail, name = it.name)
            }
        )
    }

    suspend fun getProducts():List<ProductModel>{
        val response = repository.getProducts()
        return response.map {
            ProductModel(detail = it.detail, name = it.name)
        }
    }

}