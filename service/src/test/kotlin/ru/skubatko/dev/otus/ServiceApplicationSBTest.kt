package ru.skubatko.dev.otus

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class ServiceApplicationSBTest {

    @Test
    fun contextLoads() {
    }
}
