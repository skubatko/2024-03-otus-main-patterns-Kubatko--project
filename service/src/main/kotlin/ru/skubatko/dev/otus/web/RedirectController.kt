package ru.skubatko.dev.otus.web

import ru.skubatko.dev.otus.service.RedirectService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.view.RedirectView


@Controller
class RedirectController(
    private val redirectService: RedirectService
) {

    @GetMapping("/redirect")
    fun redirect(): RedirectView =
        RedirectView(redirectService.getUrl())
}
