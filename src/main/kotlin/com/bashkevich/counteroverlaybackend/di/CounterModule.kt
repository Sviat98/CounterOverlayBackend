package com.bashkevich.counteroverlaybackend.di

import com.bashkevich.counteroverlaybackend.feature.counter.CounterRepository
import com.bashkevich.counteroverlaybackend.feature.counter.CounterService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val counterModule = module{
    singleOf(::CounterRepository)
    singleOf(::CounterService)
}