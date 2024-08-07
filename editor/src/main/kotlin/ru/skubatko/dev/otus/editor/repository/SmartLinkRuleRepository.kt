package ru.skubatko.dev.otus.editor.repository

import ru.skubatko.dev.otus.editor.entity.SmartLinkRule
import org.springframework.data.mongodb.repository.MongoRepository

interface SmartLinkRuleRepository : MongoRepository<SmartLinkRule, String> {

}
