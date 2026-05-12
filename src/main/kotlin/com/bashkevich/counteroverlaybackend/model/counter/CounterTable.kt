package com.bashkevich.counteroverlaybackend.model.counter

import com.bashkevich.counteroverlaybackend.model.theme.ThemeTable
import org.jetbrains.exposed.dao.id.IntIdTable

object CounterTable: IntIdTable("counter"){
    val name = varchar("name", 50)
    val value = integer("value")
    val themeId = reference("theme_id", ThemeTable)
}