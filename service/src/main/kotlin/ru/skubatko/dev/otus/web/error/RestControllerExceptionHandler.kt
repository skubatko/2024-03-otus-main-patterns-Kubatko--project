package ru.skubatko.dev.otus.web.error

import org.springframework.web.bind.annotation.ControllerAdvice
import org.zalando.problem.spring.web.advice.ProblemHandling
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait

@ControllerAdvice
class RestControllerExceptionHandler() : ProblemHandling, AppExceptionHandlerTrait, SecurityAdviceTrait
