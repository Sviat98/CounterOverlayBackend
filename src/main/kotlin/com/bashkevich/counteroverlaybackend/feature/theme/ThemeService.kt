package com.bashkevich.counteroverlaybackend.feature.theme

import com.bashkevich.counteroverlaybackend.model.theme.ThemeDto
import com.bashkevich.counteroverlaybackend.model.theme.toDto
import com.bashkevich.counteroverlaybackend.plugins.dbQuery
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.NotFoundException

class ThemeService(
    private val themeRepository: ThemeRepository
) {
    suspend fun getThemes(): List<ThemeDto> {
        return dbQuery {
                themeRepository.getThemes().map { it.toDto() }
        }
    }

    suspend fun getThemeById(themeId: Int): ThemeDto {
        return dbQuery {
            if (themeId != 0) {
                themeRepository.getThemeById(themeId)?.toDto()
                    ?: throw NotFoundException("No counter found!")
            } else throw BadRequestException("Incorrect id")
        }
    }
}