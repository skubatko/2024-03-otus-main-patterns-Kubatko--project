package ru.skubatko.dev.otus.common.test

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder
import io.mockk.MockKVerificationScope
import io.mockk.verify
import java.util.*

fun verifyOnce(action: MockKVerificationScope.() -> Unit) = verify(exactly = 1, verifyBlock = action)

fun verifyNotCalled(action: MockKVerificationScope.() -> Unit) = verify(exactly = 0, verifyBlock = action)

fun WireMockServer.verifyOnce(requestPatternBuilder: RequestPatternBuilder) = this.verify(1, requestPatternBuilder)

fun WireMockServer.verifyNotCalled(requestPatternBuilder: RequestPatternBuilder) = this.verify(0, requestPatternBuilder)

val token: String = JWT.create()
    .withSubject("user")
    .withIssuer("issuer")
    .withClaim("role", "USER_ROLE")
    .withIssuedAt(Date(System.currentTimeMillis()))
    .withExpiresAt(Date(System.currentTimeMillis() + 60000))
    .sign(Algorithm.none())
