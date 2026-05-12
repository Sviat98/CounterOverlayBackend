package com.bashkevich.counteroverlaybackend.plugins

import com.bashkevich.counteroverlaybackend.feature.counter.counterRoutes
import com.bashkevich.counteroverlaybackend.feature.theme.themeRoutes
import io.ktor.http.ContentType
import io.ktor.openapi.OpenApiInfo
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.openapi.OpenApiDocSource

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        counterRoutes()
        themeRoutes()
//        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.json") {
//            //version = "4.15.5"
//        }
        swaggerUI("/swaggerUI") {
            info = OpenApiInfo("My API", "1.0")
            source = OpenApiDocSource.Routing(ContentType.Application.Json) {
                routingRoot.descendants()
            }
        }
    }
}
