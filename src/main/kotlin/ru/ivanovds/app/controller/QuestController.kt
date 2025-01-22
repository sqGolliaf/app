package ru.ivanovds.app.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.ivanovds.app.service.QuestService

@RestController
class QuestController(private val questService: QuestService) {

    @GetMapping("/quest/{id}")
    fun questById(@PathVariable id: Long = 0): ResponseEntity<*> {
        return ResponseEntity(questService.questById(id), HttpStatus.OK)
    }

    @GetMapping("/quest")
    fun quest(): ResponseEntity<*> {
        return ResponseEntity(questService.quest(), HttpStatus.OK)
    }
}