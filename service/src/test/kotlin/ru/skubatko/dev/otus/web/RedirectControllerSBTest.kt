package ru.skubatko.dev.otus.web

import ru.skubatko.dev.otus.common.test.token
import ru.skubatko.dev.otus.test.AbstractSBTest
import com.marcinziolo.kotlin.wiremock.equalTo
import com.marcinziolo.kotlin.wiremock.post
import com.marcinziolo.kotlin.wiremock.returnsJson
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpHeaders
import org.springframework.test.web.servlet.get

@DisplayName("Контроллер редиректа")
class RedirectControllerSBTest : AbstractSBTest() {

    private val basePath = "/api/v1"

    @DisplayName("должен ожидаемо перенаправлять запрос")
    @Test
    fun `should expectedly redirect`() {
        wm.post {
            url equalTo "/jwt/api/v1/jwt/validate"
        }.returnsJson {
            //language=JSON
            body = """{"isValid": true}"""
        }

        mockMvc.get("$basePath/redirect") {
            header(HttpHeaders.AUTHORIZATION, "Bearer $token")
        }.andExpect {
            status { is3xxRedirection() }
            redirectedUrl("redirectedUrl")
        }
    }
}
