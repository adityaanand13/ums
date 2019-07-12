package com.aditya.ums.api.controller

import com.aditya.ums.api.Response
import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/student")
@ResponseBody
class StudentController(
        @Autowired private val studentService: StudentService
) {
    @GetMapping("/")
    fun getStudents(): ResponseEntity<Response> {
        val students = studentService.getAll()
        val usersResponse = Response()
                .success(true)
                .data(students)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    @PostMapping("/")
    fun postStudent(@Valid @RequestBody studentRequest: StudentRequest) : ResponseEntity<Response> {
        val student = studentService.create(studentRequest)
        val usersResponse = Response()
                .success(true)
                .data(student)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }
}