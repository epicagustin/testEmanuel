package com.emanuel.data.remote

import com.emanuel.data.model.LoginRequestBody
import com.emanuel.data.model.LoginResponse
import com.emanuel.data.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginServiceClient(private val api: LoginApiClient) {
    suspend fun loginDni(request: LoginRequestBody): LoginResponse {
        return withContext(Dispatchers.IO) {
            LoginResponse(
                access_token = "asdfsdjlb23b4l12b3j4hbwldfug723grfd", expires_in = 120000, listOf(
                    ProductResponse("S/ 1000", "Cuenta Sueldo"), ProductResponse("$ 1000", "Cuenta Dolares")
                )
            )
            /*val response =  api.loginEmail(request)
            response.body() ?: LoginResponseModel(null, null)*/
        }
    }
    suspend fun getProducts(): List<ProductResponse>{
        return  listOf(ProductResponse("S/ 1000", "Cuenta Sueldo"), ProductResponse("$ 1000", "Cuenta Dolares"))
    }
}