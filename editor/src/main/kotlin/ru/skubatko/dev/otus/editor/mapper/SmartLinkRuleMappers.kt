package ru.skubatko.dev.otus.editor.mapper

import ru.skubatko.dev.otus.editor.entity.SmartLinkRule
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleDto
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleUpdateDto

fun SmartLinkRule.toDto(): SmartLinkRuleDto =
    SmartLinkRuleDto(
        id = this.id,
        name = this.name,
        rule = this.rule
    )

fun SmartLinkRuleUpdateDto.toEntity(): SmartLinkRule =
    SmartLinkRule(
        name = this.name,
        rule = this.rule
    )
