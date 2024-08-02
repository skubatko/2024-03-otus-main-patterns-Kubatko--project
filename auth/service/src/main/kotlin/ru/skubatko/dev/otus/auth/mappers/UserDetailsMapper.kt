package ru.skubatko.dev.otus.auth.mappers

import ru.skubatko.dev.otus.api.models.user.UserDto
import ru.skubatko.dev.otus.auth.models.AuthUserDetails
import org.springframework.security.core.userdetails.UserDetails

fun UserDto.toUserDetails(): UserDetails =
    AuthUserDetails(
        name = this.name,
        login = this.login,
        pswd = this.password,
        role = this.role
    )
