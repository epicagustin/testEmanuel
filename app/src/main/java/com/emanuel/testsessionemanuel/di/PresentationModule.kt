package com.emanuel.di

import com.emanuel.testsessionemanuel.features.home.HomeViewModel
import com.emanuel.testsessionemanuel.features.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}
