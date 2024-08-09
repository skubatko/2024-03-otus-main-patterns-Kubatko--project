package ru.skubatko.dev.otus.editor.web

import ru.skubatko.dev.otus.api.models.rule.SmartLinkRuleDto
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleUpdateDto
import ru.skubatko.dev.otus.editor.service.RuleService
import ru.skubatko.dev.otus.editor.web.util.toResponseEntity
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("\${api.base-path:/api/v1}/admin/rules")
class AdminRuleController(
    private val ruleService: RuleService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): ResponseEntity<SmartLinkRuleDto> =
        ruleService.findById(id).toResponseEntity()

    @PostMapping
    fun add(@RequestBody dto: SmartLinkRuleUpdateDto): ResponseEntity<SmartLinkRuleDto> =
        ruleService.add(dto).toResponseEntity()

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable(value = "id") id: String,
        @RequestBody dto: SmartLinkRuleUpdateDto
    ): ResponseEntity<SmartLinkRuleDto> =
        ruleService.update(id, dto).toResponseEntity()

    @DeleteMapping("/{id}")
    fun deleteEmployeeById(@PathVariable(value = "id") id: String): ResponseEntity<Unit> =
        ruleService.delete(id).toResponseEntity()
}
