package com.bashkevich.counteroverlaybackend.model

import kotlinx.serialization.Serializable

@Serializable
data class BasicResponseBody(
    val message: String
)