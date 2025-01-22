package ru.ivanovds.app.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.ivanovds.app.domain.ApiExceptionResponse
import ru.ivanovds.app.exception.NotFoundException

@RestControllerAdvice
class QuestControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleEntityValidateEx(ex: NotFoundException): ApiExceptionResponse {
        val details = listOf(ex.message)
        return ApiExceptionResponse(HttpStatus.NOT_FOUND, details)
    }
}