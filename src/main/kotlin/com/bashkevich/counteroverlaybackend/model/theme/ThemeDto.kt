package com.bashkevich.counteroverlaybackend.model.theme

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThemeDto(
    @SerialName("id")
    val id: String,
    @SerialName("content")
    val content: ThemeContent
)

fun ThemeEntity.toDto(): ThemeDto = ThemeDto(
    id = id.value.toString(),
    content = content
)