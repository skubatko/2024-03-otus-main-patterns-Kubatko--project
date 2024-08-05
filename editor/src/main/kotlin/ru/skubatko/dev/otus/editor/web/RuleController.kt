package ru.skubatko.dev.otus.editor.web

import ru.skubatko.dev.otus.editor.model.GetRulesResponseDto
import ru.skubatko.dev.otus.editor.service.RuleService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("\${api.base-path:/api/v1}/admin/rules")
class RuleController(
    private val ruleService: RuleService
) {

    @GetMapping
    fun get(): ResponseEntity<GetRulesResponseDto> =
        ResponseEntity.ok(ruleService.get())
}
