package com.emanuel.di

import com.emanuel.data.core.RetrofitBuilder
import com.emanuel.data.remote.LoginApiClient
import com.emanuel.data.remote.LoginServiceClient
import com.emanuel.data.repository.ProductsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule = module {
    single {
        RetrofitBuilder(androidContext()).createService(LoginApiClient::class.java)
    }
}
val remoteModule = module {
    factory { LoginServiceClient(get()) }
}

val repositoryModule = module {
    single { ProductsRepository(get()) }
}
