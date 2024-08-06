package ru.skubatko.dev.otus.test.config

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.event.ContextClosedEvent

class WireMockInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        val wireMockServer = WireMockServer(WireMockConfiguration().dynamicPort())
        wireMockServer.start()
        applicationContext.beanFactory.registerSingleton("wm", wireMockServer)
        applicationContext.addApplicationListener { if (it is ContextClosedEvent) wireMockServer.stop() }
        TestPropertyValues
            .of(mapOf("wiremock.server.base-url" to wireMockServer.baseUrl()))
            .applyTo(applicationContext)
    }
}
