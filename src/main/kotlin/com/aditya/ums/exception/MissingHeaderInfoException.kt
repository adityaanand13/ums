package com.aditya.ums.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.BAD_REQUEST)
class MissingHeaderInfoException(message: String?) : RuntimeException(message) {
    @Synchronized
    fun fillInStackTrace(): Throwable? {
        return this
    }
    companion object {
        private const val serialVersionUID = 1L
    }
}