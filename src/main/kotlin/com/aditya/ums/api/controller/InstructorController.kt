package com.aditya.ums.api.controller

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.InstructorConverter
import com.aditya.ums.service.InstructorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/instructor")
@ResponseBody
class InstructorController(
        @Autowired private val instructorService: InstructorService
) {
    @GetMapping("/")
    fun getInstructors(): ResponseEntity<Response> {
        val instructor = instructorService.getAll()
        val instructorsResponse = Response()
                .success(true)
                .data(InstructorConverter.convertToResponses(instructor))
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(instructorsResponse, HttpStatus.OK)
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun postInstructor(@Valid @RequestBody instructorRequest: InstructorRequest) : ResponseEntity<Response> {
        println(instructorRequest.username)
        val instructor = instructorService.createInstructor(instructorRequest)
        val instructorResponse = Response()
                .success(true)
                .data(InstructorConverter.convertToResponse(instructor))
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(instructorResponse, HttpStatus.OK)
    }

//    @PostMapping("/add-course")
//    fun addCourse(@Valid @RequestBody addCourseRequest: AddCourseRequest): ResponseEntity<Response> {
//        val instructor =  instructorService.addCourse(addCourseRequest)
//        val instructorResponse = Response()
//                .success(true)
//                .data(InstructorConverter.convertToResponse(instructor))
//                .contentType("application/json")
//                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
//        return ResponseEntity(instructorResponse, HttpStatus.OK)
//    }
}