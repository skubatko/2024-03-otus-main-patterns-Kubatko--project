package ru.skubatko.dev.otus.web

import ru.skubatko.dev.otus.service.RedirectService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
@RequestMapping("\${api.base-path:/api/v1}")
@SecurityRequirement(name = "bearerAuth")
class RedirectController(
    private val redirectService: RedirectService
) {

    @GetMapping("/redirect")
    fun redirect(): RedirectView =
        RedirectView(redirectService.getLink())
}
