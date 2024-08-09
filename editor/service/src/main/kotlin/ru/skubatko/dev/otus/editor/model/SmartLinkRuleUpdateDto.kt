package ru.skubatko.dev.otus.editor.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SmartLinkRuleUpdateDto(
    @get:JsonProperty("name", required = true) val name: String,
    @get:JsonProperty("rule", required = true) val rule: String,
    @get:JsonProperty("link", required = true) val link: String,
)
