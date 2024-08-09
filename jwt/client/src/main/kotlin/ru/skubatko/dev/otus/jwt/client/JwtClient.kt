@file:Suppress("unused")

package ru.skubatko.dev.otus.jwt.client

import ru.skubatko.dev.otus.api.models.jwt.JwtGenerationReqDto
import ru.skubatko.dev.otus.api.models.jwt.JwtGenerationRespDto
import ru.skubatko.dev.otus.api.models.jwt.JwtUsernameRespDto
import ru.skubatko.dev.otus.api.models.jwt.JwtValidationReqDto
import ru.skubatko.dev.otus.api.models.jwt.JwtValidationRespDto
import org.springframework.http.HttpEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.client.postForObject
import org.springframework.web.util.UriComponentsBuilder

class JwtClient(
    private val restTemplate: RestTemplate
) {
    private val baseUrl = "/api/v1/jwt"

    fun generate(jwtGenerationReqDto: JwtGenerationReqDto) =
        restTemplate.postForObject<JwtGenerationRespDto>("$baseUrl/generate", HttpEntity(jwtGenerationReqDto))

    fun techToken() =
        restTemplate.postForObject<JwtGenerationRespDto>("$baseUrl/tech-token")

    fun getUsername(jwtToken: String): JwtUsernameRespDto? =
        restTemplate.getForObject<JwtUsernameRespDto>(
            UriComponentsBuilder.fromPath("$baseUrl/username").queryParam("token", jwtToken).encode().toUriString()
        )

    fun isTokenValid(jwtValidationReqDto: JwtValidationReqDto) =
        restTemplate.postForObject<JwtValidationRespDto>("$baseUrl/validate", HttpEntity(jwtValidationReqDto))
}
