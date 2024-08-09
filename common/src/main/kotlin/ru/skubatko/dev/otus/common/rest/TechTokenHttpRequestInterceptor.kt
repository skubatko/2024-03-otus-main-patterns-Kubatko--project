package ru.skubatko.dev.otus.common.rest

import ru.skubatko.dev.otus.jwt.client.JwtClient
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse

class TechTokenHttpRequestInterceptor(
    private val jwtClient: JwtClient
) : ClientHttpRequestInterceptor {

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution,
    ): ClientHttpResponse {
        request.headers[HttpHeaders.AUTHORIZATION] = "Bearer ${jwtClient.techToken()}"
        return execution.execute(request, body)
    }
}
