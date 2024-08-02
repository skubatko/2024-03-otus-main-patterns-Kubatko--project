package ru.skubatko.dev.otus.auth.client

import ru.skubatko.dev.otus.common.rest.RestProps
import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

@ConfigurationProperties("msa.clients.auth")
class AuthClientProps(
    baseUrl: String = "http://localhost:8181",
    connectTimeout: Duration = Duration.ofSeconds(15),
    readTimeout: Duration = Duration.ofSeconds(40)
) : RestProps(baseUrl, connectTimeout, readTimeout)