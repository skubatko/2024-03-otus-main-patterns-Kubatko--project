package ru.skubatko.dev.otus.editor.service

import ru.skubatko.dev.otus.editor.mapper.toDto
import ru.skubatko.dev.otus.editor.mapper.toEntity
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleDto
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleUpdateDto
import ru.skubatko.dev.otus.editor.repository.SmartLinkRuleRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class RuleService(
    private val smartLinkRuleRepository: SmartLinkRuleRepository
) {

    fun findById(id: String): SmartLinkRuleDto? =
        smartLinkRuleRepository.findById(id).getOrNull()?.toDto()

    fun findAll(): List<SmartLinkRuleDto> =
        smartLinkRuleRepository.findAll().map { it.toDto() }

    fun add(dto: SmartLinkRuleUpdateDto): SmartLinkRuleDto =
        smartLinkRuleRepository.insert(dto.toEntity()).toDto()

    fun update(id: String, dto: SmartLinkRuleUpdateDto): SmartLinkRuleDto? =
        smartLinkRuleRepository.findById(id).getOrNull()?.let {
            smartLinkRuleRepository.save(it.copy(name = dto.name, rule = dto.rule))
                .toDto()
        }

    fun delete(id: String): Unit? =
        smartLinkRuleRepository.findById(id).getOrNull()?.let {
            smartLinkRuleRepository.delete(it)
        }
}
