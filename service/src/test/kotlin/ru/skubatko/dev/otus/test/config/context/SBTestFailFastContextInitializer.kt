package ru.skubatko.dev.otus.test.config.context

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import java.util.concurrent.atomic.AtomicBoolean

class SBTestFailFastContextInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        val error: Boolean = flag.getAndSet(true)
        if (error) failFast()
    }

    companion object {
        private val flag = AtomicBoolean()
    }
}
