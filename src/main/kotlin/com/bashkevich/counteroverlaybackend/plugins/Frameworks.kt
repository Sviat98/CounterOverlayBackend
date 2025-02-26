package com.bashkevich.counteroverlaybackend.plugins

import com.bashkevich.counteroverlaybackend.di.counterModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDependencyInjection() {
    install(Koin) {
        slf4jLogger()
        modules(counterModule)
    }
}
