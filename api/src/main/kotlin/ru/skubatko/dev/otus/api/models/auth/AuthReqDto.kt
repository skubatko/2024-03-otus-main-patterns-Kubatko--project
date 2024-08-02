package ru.skubatko.dev.otus.api.models.auth

data class AuthReqDto(
    val login: String,
    val password: String,
    val gameId: Int
)
