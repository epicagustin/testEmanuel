package com.emanuel.di

import com.emanuel.domine.usecase.ProductUseCase
import org.koin.dsl.module

val usecaseModule = module {
    factory { ProductUseCase(get()) }
}