package ru.skubatko.dev.otus.user.mappers

import ru.skubatko.dev.otus.api.models.user.UserDto
import ru.skubatko.dev.otus.user.entity.UserEntity

fun UserEntity.toDto() =
    UserDto(
        name = this.name,
        login = this.login,
        password = this.password,
        role = this.role
    )
