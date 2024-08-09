package ru.skubatko.dev.otus.editor.web.error

import com.fasterxml.jackson.databind.exc.MismatchedInputException
import jakarta.xml.bind.ValidationException
import org.springframework.core.codec.CodecException
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.zalando.problem.Status
import org.zalando.problem.ThrowableProblem
import org.zalando.problem.spring.common.AdviceTrait
import ru.sokomishalov.commons.core.log.Loggable
import javax.naming.ServiceUnavailableException

interface AppExceptionHandlerTrait : AdviceTrait {

    override fun toProblem(throwable: Throwable): ThrowableProblem {
        return toProblem(throwable, resolveStatus(throwable)).also { log(it) }
    }

    fun resolveStatus(throwable: Throwable): Status =
        when (throwable) {
            // 400
            // validation
            is IllegalArgumentException,
            is MismatchedInputException,
            is MethodArgumentNotValidException,
            is MissingServletRequestParameterException,
            is ValidationException,
            is HttpMessageNotReadableException,
            is CodecException,
                // business
            -> Status.BAD_REQUEST

            // 503
            is ServiceUnavailableException,
            -> Status.SERVICE_UNAVAILABLE

            // 501
            is NotImplementedError,
            -> Status.NOT_IMPLEMENTED

            // default
            else -> super.resolveResponseStatus(throwable)
                ?.let { Status.valueOf(it.code.value()) }
                ?: Status.INTERNAL_SERVER_ERROR
        }

    fun log(problem: ThrowableProblem) {
        when (problem.status?.statusCode) {
            null -> Unit
            in (400..499) -> logger.warn(problem.message, problem.cause ?: problem)
            in (500..599) -> logger.error(problem.message, problem.cause ?: problem)
        }
    }

    companion object : Loggable
}
