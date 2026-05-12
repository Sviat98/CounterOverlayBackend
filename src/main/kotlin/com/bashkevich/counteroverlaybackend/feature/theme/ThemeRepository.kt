package com.bashkevich.counteroverlaybackend.feature.theme

import com.bashkevich.counteroverlaybackend.model.theme.ThemeEntity

class ThemeRepository {
    fun getThemes(): List<ThemeEntity> {
        return ThemeEntity.all().toList()
    }

    fun getThemeById(id: Int): ThemeEntity? {
        return ThemeEntity.findById(id)
    }
}