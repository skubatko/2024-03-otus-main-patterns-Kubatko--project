package ru.skubatko.dev.otus.jwt.mappers

import ru.skubatko.dev.otus.api.models.jwt.JwtGenerationReqDto
import ru.skubatko.dev.otus.api.models.user.User
import ru.skubatko.dev.otus.api.models.user.UserAuthority
import ru.skubatko.dev.otus.api.models.user.Username

fun JwtGenerationReqDto.toUser() =
    User(
        name = Username(this.username),
        authority = UserAuthority(this.authority)
    )
