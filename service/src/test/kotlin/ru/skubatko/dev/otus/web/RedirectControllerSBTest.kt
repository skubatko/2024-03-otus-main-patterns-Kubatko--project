package ru.skubatko.dev.otus.web

import ru.skubatko.dev.otus.test.AbstractSBTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.get

@DisplayName("Контроллер редиректа")
class RedirectControllerSBTest : AbstractSBTest() {

    private val basePath = "/api/v1"

    @DisplayName("должен ожидаемо перенаправлять запрос")
    @Test
    fun `should expectedly redirect`() {
        mockMvc.get("$basePath/redirect")
            .andExpect {
                status { is3xxRedirection() }
                redirectedUrl("redirectedUrl")
            }
    }
}
