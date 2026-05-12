package com.bashkevich.counteroverlaybackend.model.counter

import com.bashkevich.counteroverlaybackend.model.theme.ThemeEntity
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CounterEntity (id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CounterEntity>(CounterTable)

    var name by CounterTable.name
    var value  by CounterTable.value
    var theme by ThemeEntity referencedOn CounterTable.themeId
}