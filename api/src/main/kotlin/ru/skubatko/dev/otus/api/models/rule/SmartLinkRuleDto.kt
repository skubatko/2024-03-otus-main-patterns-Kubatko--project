package ru.skubatko.dev.otus.api.models.rule

import com.fasterxml.jackson.annotation.JsonProperty

data class SmartLinkRuleDto(
    @get:JsonProperty("id", required = true) val id: String,
    @get:JsonProperty("name", required = true) val name: String,
    @get:JsonProperty("rule", required = true) val rule: String,
    @get:JsonProperty("link", required = true) val link: String,
)
