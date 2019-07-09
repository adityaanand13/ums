package com.aditya.ums.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException : RuntimeException {
    var className: String = ""
    var error: String = ""
    constructor(message: String, ex: Exception?): super(message, ex)
    constructor(message: String): super(message)
    constructor(ex: Exception): super(ex)
    constructor(message: String, className: String, error: String): super(message) {
        this.className = className
        this.error = error
    }
}