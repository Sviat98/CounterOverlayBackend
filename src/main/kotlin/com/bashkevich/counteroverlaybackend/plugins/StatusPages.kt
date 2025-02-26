package com.bashkevich.counteroverlaybackend.plugins

import com.bashkevich.counteroverlaybackend.model.BasicResponseBody
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.NotFoundException
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond

fun Application.configureStatusPages(){
    install(StatusPages){
        exception<Throwable>{call, cause ->
            val statusCode = mapExceptionToStatusCode(cause)
            call.respond(statusCode,BasicResponseBody(message = cause.message.toString()))
        }
    }
}

fun mapExceptionToStatusCode(exception: Throwable): HttpStatusCode {
    return when (exception) {
        is NotFoundException -> HttpStatusCode.NotFound // 404
        is IllegalArgumentException, is BadRequestException -> HttpStatusCode.BadRequest // 400
        is IllegalStateException -> HttpStatusCode.Conflict // 409
        else -> HttpStatusCode.InternalServerError // 500
    }
}