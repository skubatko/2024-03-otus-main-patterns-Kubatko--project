package ru.skubatko.dev.otus.editor.web.util

import org.springframework.http.ResponseEntity

fun <T> T?.toResponseEntity(): ResponseEntity<T> = when {
    this == null -> ResponseEntity.notFound().build()
    else -> ResponseEntity.ok(this)
}
