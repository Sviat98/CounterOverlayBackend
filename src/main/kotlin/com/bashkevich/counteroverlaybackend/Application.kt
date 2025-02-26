package com.bashkevich.counteroverlaybackend

import com.bashkevich.counteroverlaybackend.plugins.configureCors
import com.bashkevich.counteroverlaybackend.plugins.configureDatabase
import com.bashkevich.counteroverlaybackend.plugins.configureDependencyInjection
import com.bashkevich.counteroverlaybackend.plugins.configureMonitoring
import com.bashkevich.counteroverlaybackend.plugins.configureRouting
import com.bashkevich.counteroverlaybackend.plugins.configureSerialization
import com.bashkevich.counteroverlaybackend.plugins.configureSockets
import com.bashkevich.counteroverlaybackend.plugins.configureStatusPages
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureCors()
    configureSockets()
    configureDependencyInjection()
    configureMonitoring()
    configureDatabase()
    configureRouting()
    configureStatusPages()
}
