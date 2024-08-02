package ru.skubatko.dev.otus.jwt.client

import ru.skubatko.dev.otus.api.models.jwt.JwtGameIdRespDto
import ru.skubatko.dev.otus.api.models.jwt.JwtGenerationReqDto
import ru.skubatko.dev.otus.api.models.jwt.JwtGenerationRespDto
import ru.skubatko.dev.otus.api.models.jwt.JwtUsernameRespDto
import ru.skubatko.dev.otus.api.models.jwt.JwtValidationReqDto
import ru.skubatko.dev.otus.api.models.jwt.JwtValidationRespDto
import org.springframework.http.HttpEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

class JwtClient(
    private val restTemplate: RestTemplate
) {
    private val baseUrl = "/api/v1/jwt"

    fun generate(jwtGenerationReqDto: JwtGenerationReqDto) =
        restTemplate.postForObject(
            "$baseUrl/generate",
            HttpEntity(jwtGenerationReqDto),
            JwtGenerationRespDto::class.java
        )

    fun getUsername(jwtToken: String): JwtUsernameRespDto? =
        restTemplate.getForObject(
            UriComponentsBuilder.fromPath("$baseUrl/username").queryParam("token", jwtToken).encode().toUriString(),
            JwtUsernameRespDto::class.java
        )

    fun isTokenValid(jwtValidationReqDto: JwtValidationReqDto) =
        restTemplate.postForObject(
            "$baseUrl/generate",
            HttpEntity(jwtValidationReqDto),
            JwtValidationRespDto::class.java
        )

    fun getGameId(jwtToken: String): JwtGameIdRespDto? =
        restTemplate.getForObject(
            UriComponentsBuilder.fromPath("$baseUrl/game").queryParam("token", jwtToken).encode().toUriString(),
            JwtGameIdRespDto::class.java
        )
}
