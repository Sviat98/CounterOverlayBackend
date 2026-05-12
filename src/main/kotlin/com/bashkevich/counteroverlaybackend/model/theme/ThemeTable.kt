package com.bashkevich.counteroverlaybackend.model.theme

import kotlinx.serialization.json.Json
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.json.jsonb

object ThemeTable : IntIdTable("counter_theme"){
    val content = jsonb<ThemeContent>("content",Json.Default)
}