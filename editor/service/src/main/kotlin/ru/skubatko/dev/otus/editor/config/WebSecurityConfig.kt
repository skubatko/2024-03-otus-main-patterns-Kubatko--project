package ru.skubatko.dev.otus.editor.config

import ru.skubatko.dev.otus.api.models.user.UserRole
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport

@EnableWebSecurity
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
@Import(SecurityProblemSupport::class)
@Configuration(proxyBeanMethods = false)
class WebSecurityConfig {

    @Bean
    fun securityFilterChain(
        http: HttpSecurity,
        problemSupport: SecurityProblemSupport,
        authenticationManager: AuthenticationManager
    ): SecurityFilterChain =
        http
            .csrf { it.disable() }
            .cors { it.disable() }
            .authorizeHttpRequests { auth ->
                auth.requestMatchers(*AUTH_WHITELIST).anonymous()
                    .requestMatchers("/api/v1/admin/**").hasAuthority(UserRole.ROLE_ADMIN.name)
                    .anyRequest().authenticated()
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .exceptionHandling { exceptionHandlingConfigurer ->
                exceptionHandlingConfigurer.authenticationEntryPoint(problemSupport)
                exceptionHandlingConfigurer.accessDeniedHandler(problemSupport)
            }
            .oauth2ResourceServer { oauth2 ->
                oauth2.jwt { jwtConfigurer ->
                    jwtConfigurer.authenticationManager(authenticationManager)
                }
            }
            .build()

    companion object {
        val AUTH_WHITELIST = arrayOf(
            "/",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/actuator/**"
        )
    }
}
