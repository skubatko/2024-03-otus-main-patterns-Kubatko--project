package ru.skubatko.dev.otus.jwt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtApplication

fun main(args: Array<String>) {
    runApplication<JwtApplication>(*args)
}
