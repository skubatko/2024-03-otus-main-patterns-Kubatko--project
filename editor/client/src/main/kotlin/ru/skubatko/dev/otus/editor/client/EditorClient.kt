@file:Suppress("unused")

package ru.skubatko.dev.otus.editor.client

import ru.skubatko.dev.otus.api.models.rule.SmartLinkRuleDto
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

class EditorClient(
    private val restTemplate: RestTemplate
) {
    private val baseUrl = "/api/v1/rules"

    fun getAll() =
        restTemplate.getForObject<List<SmartLinkRuleDto>>(baseUrl)
}
