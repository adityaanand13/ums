package com.aditya.ums.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class InternalServerError (private val area: String,
                           private val reason: String
): RuntimeException(String.format("Error in %s ; due to : %s,", area, reason)){
    //supress useless stacktrace
    @Synchronized
    fun fillInStackTrace(): Throwable? {
        return this
    }
    companion object {
        private const val serialVersionUID = 1L
    }
}