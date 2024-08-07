package ru.skubatko.dev.otus.editor.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.sokomishalov.commons.core.consts.EMPTY

@Document("smart_link_rules")
data class SmartLinkRule(
    @Id val id: String = EMPTY,
    val name: String = EMPTY,
    val rule: String = EMPTY,
)
