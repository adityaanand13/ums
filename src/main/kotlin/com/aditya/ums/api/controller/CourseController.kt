package com.aditya.ums.api.controller

import com.aditya.ums.api.Response
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

class CourseController(
        @Autowired private val courseService: CourseService
){
    @GetMapping("/")
    fun getCourses(): ResponseEntity<Response> {
        val courses = courseService.getAll()
        val coursesResponse = Response()
                .success(true)
                .data(courses)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(coursesResponse, HttpStatus.OK)
    }

    @PostMapping("/")
    fun postStudent(@Valid @RequestBody courseRequest: CourseRequest) : ResponseEntity<Response> {
        val course = courseService.create(courseRequest)
        val courseResponse = Response()
                .success(true)
                .data(course)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(courseResponse, HttpStatus.OK)
    }
}