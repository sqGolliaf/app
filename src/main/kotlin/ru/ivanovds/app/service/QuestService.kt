package ru.ivanovds.app.service

import ru.ivanovds.app.domain.EmployeeResponse

interface QuestService {
    fun questById(key: String): EmployeeResponse
    fun quest(): List<EmployeeResponse>
}