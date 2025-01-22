package ru.ivanovds.app.domain

data class EmployeeResponse(
    val id: Int,
    val questionText: String,
    val questionType: String,
    val options: List<String>? = null
)