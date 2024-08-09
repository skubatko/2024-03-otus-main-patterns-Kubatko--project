package ru.skubatko.dev.otus.editor.web

import ru.skubatko.dev.otus.api.models.rule.SmartLinkRuleDto
import ru.skubatko.dev.otus.editor.service.RuleService
import ru.skubatko.dev.otus.editor.web.util.toResponseEntity
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/v1/rules")
class RuleController(
    private val ruleService: RuleService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<SmartLinkRuleDto>> =
        ruleService.findAll().toResponseEntity()
}
