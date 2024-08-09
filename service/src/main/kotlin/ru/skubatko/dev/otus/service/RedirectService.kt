package ru.skubatko.dev.otus.service

import org.springframework.stereotype.Service

@Service
class RedirectService {

    fun getLink(): String {
        return "redirectedUrl"
    }
}
