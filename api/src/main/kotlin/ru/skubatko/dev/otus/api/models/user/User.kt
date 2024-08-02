package ru.skubatko.dev.otus.api.models.user

data class User(
    val name: Username,
    val authority: UserAuthority
)
