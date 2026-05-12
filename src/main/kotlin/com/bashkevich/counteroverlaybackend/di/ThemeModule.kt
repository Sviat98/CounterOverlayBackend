package com.bashkevich.counteroverlaybackend.di

import com.bashkevich.counteroverlaybackend.feature.theme.ThemeRepository
import com.bashkevich.counteroverlaybackend.feature.theme.ThemeService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val themeModule = module {
    singleOf(::ThemeRepository)
    singleOf(::ThemeService)
}