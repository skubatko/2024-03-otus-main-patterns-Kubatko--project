package ru.skubatko.dev.otus.test

import ru.skubatko.dev.otus.test.config.WireMockInitializer
import ru.skubatko.dev.otus.test.config.context.SBTestFailFastContextInitializer
import com.github.tomakehurst.wiremock.WireMockServer
import io.mockk.clearAllMocks
import org.junit.jupiter.api.AfterEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ContextConfiguration(
    initializers = [
        WireMockInitializer::class,
        SBTestFailFastContextInitializer::class
    ]
)
abstract class AbstractSBTest {
    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    lateinit var wm: WireMockServer

    @AfterEach
    fun tearDownSbTest() {
        wm.resetAll()
        clearAllMocks()
    }
}
