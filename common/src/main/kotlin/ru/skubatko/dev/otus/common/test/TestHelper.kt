package ru.skubatko.dev.otus.common.test

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder
import io.mockk.MockKVerificationScope
import io.mockk.verify

fun verifyOnce(action: MockKVerificationScope.() -> Unit) = verify(exactly = 1, verifyBlock = action)

fun verifyNotCalled(action: MockKVerificationScope.() -> Unit) = verify(exactly = 0, verifyBlock = action)

fun WireMockServer.verifyOnce(requestPatternBuilder: RequestPatternBuilder) = this.verify(1, requestPatternBuilder)

fun WireMockServer.verifyNotCalled(requestPatternBuilder: RequestPatternBuilder) = this.verify(0, requestPatternBuilder)
