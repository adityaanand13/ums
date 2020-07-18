package com.aditya.ums.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class ConflictException(
        val fieldName: String,
        val fieldValue: Any
) : RuntimeException(String.format("Conflict in value of field for value '%s' : '%s'", fieldName, fieldValue)){
    //suppress useless stack trace
    @Synchronized
    fun fillInStackTrace(): Throwable? {
        return this
    }
    companion object {
        private const val serialVersionUID = 1L
    }
}