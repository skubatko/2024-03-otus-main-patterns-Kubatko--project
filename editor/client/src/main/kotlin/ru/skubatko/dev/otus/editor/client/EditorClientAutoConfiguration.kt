package ru.skubatko.dev.otus.editor.client

import ru.skubatko.dev.otus.common.rest.RestTemplateFactory
import ru.skubatko.dev.otus.common.rest.TechTokenHttpRequestInterceptor
import ru.skubatko.dev.otus.jwt.client.JwtClient
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import ru.sokomishalov.commons.core.serialization.OBJECT_MAPPER

@AutoConfiguration
@EnableConfigurationProperties(EditorClientProps::class)
class EditorClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun objectMapper() = OBJECT_MAPPER

    @Bean
    fun editorClient(
        restTemplateBuilder: RestTemplateBuilder,
        authClientProps: EditorClientProps,
        jwtClient: JwtClient
    ) =
        EditorClient(
            RestTemplateFactory.create(
                restTemplateBuilder,
                authClientProps,
                TechTokenHttpRequestInterceptor(jwtClient)
            )
        )
}
