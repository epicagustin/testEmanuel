package com.emanuel.data.remote

import com.emanuel.data.model.LoginRequestBody
import com.emanuel.data.model.LoginResponse
import com.emanuel.data.model.ProductResponse
import ir.logicbase.mockfit.Mock
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApiClient {
    @Mock("login_success_response.json")
    @POST("api/unUrlDeLogin")
    suspend fun loginEmail(
        @Body loginRequest: LoginRequestBody
    ): Response<LoginResponse>

    @GET("api/getProducts")
    suspend fun getProducts(): Response<List<ProductResponse>>
}