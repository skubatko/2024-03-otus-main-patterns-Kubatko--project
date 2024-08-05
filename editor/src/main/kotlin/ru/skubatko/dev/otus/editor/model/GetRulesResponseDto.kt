package ru.skubatko.dev.otus.editor.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GetRulesResponseDto(
    @get:JsonProperty("rule", required = true) val rule: String
)
