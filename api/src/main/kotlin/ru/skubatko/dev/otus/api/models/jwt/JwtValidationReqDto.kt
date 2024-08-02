package ru.skubatko.dev.otus.api.models.jwt

data class JwtValidationReqDto(
    val token: String?,
    val username: String,
)
