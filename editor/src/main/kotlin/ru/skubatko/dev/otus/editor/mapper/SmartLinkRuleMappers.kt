package ru.skubatko.dev.otus.editor.mapper

import ru.skubatko.dev.otus.editor.entity.SmartLinkRule
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleDto
import ru.skubatko.dev.otus.editor.model.SmartLinkRuleUpdateDto
import java.util.*

fun SmartLinkRule.toDto(): SmartLinkRuleDto =
    SmartLinkRuleDto(
        id = this.id,
        name = this.name,
        rule = this.rule
    )

fun SmartLinkRuleUpdateDto.toEntity(): SmartLinkRule =
    SmartLinkRule(
        id = UUID.randomUUID().toString(),
        name = this.name,
        rule = this.rule
    )
