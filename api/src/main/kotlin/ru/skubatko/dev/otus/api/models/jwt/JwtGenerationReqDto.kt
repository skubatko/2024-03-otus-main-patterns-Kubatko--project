package ru.skubatko.dev.otus.api.models.jwt

data class JwtGenerationReqDto(
    val username: String,
    val authority: String,
)
