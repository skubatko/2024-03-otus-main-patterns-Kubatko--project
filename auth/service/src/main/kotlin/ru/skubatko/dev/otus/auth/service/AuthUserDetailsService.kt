package ru.skubatko.dev.otus.auth.service

import ru.skubatko.dev.otus.auth.mappers.toUserDetails
import ru.skubatko.dev.otus.user.client.UserClient
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.sokomishalov.commons.core.consts.EMPTY

@Service
class AuthUserDetailsService(
    private val userClient: UserClient
) : UserDetailsService {

    override fun loadUserByUsername(username: String?) =
        userClient.findByLogin(username ?: EMPTY)
            ?.toUserDetails()
            ?: throw UsernameNotFoundException("User not found")
}
