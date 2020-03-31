package com.aditya.ums.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import javax.servlet.ServletException


@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {
    private val INCORRECT_REQUEST = "INCORRECT_REQUEST"
    private val BAD_REQUEST = "BAD_REQUEST"

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceFoundException(ex: ResourceNotFoundException, request: WebRequest?): ResponseEntity<ExceptionResponse> {
        println("hello you have reached here")
        val details: MutableList<String> = ArrayList()
        details.add(ex.localizedMessage)
        val error = ExceptionResponse(INCORRECT_REQUEST, details)
        return ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(MissingHeaderInfoException::class)
    fun handleInvalidTraceIdException(ex: MissingHeaderInfoException, request: WebRequest?): ResponseEntity<ExceptionResponse> {
        val details: MutableList<String> = ArrayList()
        details.add(ex.localizedMessage)
        val error = ExceptionResponse(BAD_REQUEST, details)
        return ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InternalServerError::class)
    fun handleServerException(ex: InternalServerError, request: WebRequest?): ResponseEntity<ExceptionResponse> {
        val details: MutableList<String> = ArrayList()
        details.add(ex.localizedMessage)
        val error = ExceptionResponse(BAD_REQUEST, details)
        return ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UsernameNotFoundException::class)
    fun handleUsernameNotFoundException(ex: UsernameNotFoundException, request: WebRequest?): ResponseEntity<ExceptionResponse>{
        val details: MutableList<String> = ArrayList()
        details.add(ex.localizedMessage)
        val error = ExceptionResponse("NOT_FOUND", details)
        return ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND)
    }

}