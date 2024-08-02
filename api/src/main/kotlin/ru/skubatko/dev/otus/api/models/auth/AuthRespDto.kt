package ru.skubatko.dev.otus.api.models.auth

data class AuthRespDto(
    val token: String?,
    val username: String?
)
