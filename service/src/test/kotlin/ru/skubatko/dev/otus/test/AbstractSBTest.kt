package ru.skubatko.dev.otus.test

import ru.skubatko.dev.otus.test.config.context.SBTestFailFastContextInitializer
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
        SBTestFailFastContextInitializer::class
    ]
)
abstract class AbstractSBTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @AfterEach
    fun tearDownSbTest() {
        clearAllMocks()
    }
}
