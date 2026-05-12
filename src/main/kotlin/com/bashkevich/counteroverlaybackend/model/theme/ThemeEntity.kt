package com.bashkevich.counteroverlaybackend.model.theme

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThemeEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ThemeEntity>(ThemeTable)

    var content by ThemeTable.content
}