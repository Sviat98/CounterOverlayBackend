package com.bashkevich.counteroverlaybackend.feature.theme

import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.application
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.themeRoutes() {
    val themeService by application.inject<ThemeService>()

    route("/themes") {
        get {
            val themes = themeService.getThemes()

            call.respond(themes)
        }
        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: 0

            val theme = themeService.getThemeById(themeId = id)

            call.respond(theme)
        }
    }
}