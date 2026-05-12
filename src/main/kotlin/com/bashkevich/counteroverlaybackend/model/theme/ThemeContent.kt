package com.bashkevich.counteroverlaybackend.model.theme

import kotlinx.serialization.Serializable

@Serializable
data class ThemeContent(
    val backgroundColor: ThemeColor,
    val textColor: ThemeColor,
)

@Serializable
data class ThemeColor(
    val color: String,
    val alpha: Float = 1f,
)
