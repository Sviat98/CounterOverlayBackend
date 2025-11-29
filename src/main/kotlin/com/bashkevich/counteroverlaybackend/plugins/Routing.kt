package com.bashkevich.counteroverlaybackend.plugins

import com.bashkevich.counteroverlaybackend.feature.counter.counterRoutes
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        counterRoutes()
        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.json") {
            //version = "4.15.5"
        }
    }
}
