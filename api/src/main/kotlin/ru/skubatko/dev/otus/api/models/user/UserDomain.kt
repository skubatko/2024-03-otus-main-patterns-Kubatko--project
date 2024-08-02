package ru.skubatko.dev.otus.api.models.user

@JvmInline
value class Username(private val value: String) {
    fun asString() = value
}

@JvmInline
value class UserAuthority(private val value: String) {
    fun asString() = value
}
