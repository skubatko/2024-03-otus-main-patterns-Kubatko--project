package ru.skubatko.dev.otus.user.config

import ru.skubatko.dev.otus.api.models.user.UserRole
import ru.skubatko.dev.otus.user.entity.UserEntity
import ru.skubatko.dev.otus.user.repository.UserRepository
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DbPopulation(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @EventListener(ContextRefreshedEvent::class)
    fun populate() {
        userRepository.saveAll(
            listOf(
                UserEntity(
                    login = "admin",
                    name = "admin",
                    password = passwordEncoder.encode("123"),
                    role = UserRole.ROLE_ADMIN
                ),
                UserEntity(
                    login = "user1",
                    name = "name1",
                    password = passwordEncoder.encode("123"),
                    role = UserRole.ROLE_USER
                ),
                UserEntity(
                    login = "user2",
                    name = "name2",
                    password = passwordEncoder.encode("123"),
                    role = UserRole.ROLE_USER
                ),
                UserEntity(
                    login = "user3",
                    name = "name3",
                    password = passwordEncoder.encode("123"),
                    role = UserRole.ROLE_USER
                )
            )
        )
    }
}
