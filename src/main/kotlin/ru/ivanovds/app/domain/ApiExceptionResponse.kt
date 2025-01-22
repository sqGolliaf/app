package ru.ivanovds.app.domain

import org.springframework.http.HttpStatus

data class ApiExceptionResponse(
    val status: HttpStatus,
    val details: List<String>
)