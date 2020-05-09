package com.aditya.ums.api.controller

import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.CourseConverter
import com.aditya.ums.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/course")
@ResponseBody
class CourseController(
        @Autowired private val courseService: CourseService
) {
    @GetMapping("/")
    fun getCourses(): ResponseEntity<Response> {
        val courses = CourseConverter.convertToResponses(courseService.getAll())
        val coursesResponse = Response()
                .success(true)
                .data(courses)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(coursesResponse, HttpStatus.OK)
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{course_id}/add-batch/{start_year}")
    fun addBatch(
            @PathVariable("course_id", required = true) course_id: Int, @PathVariable start_year: Int
    ): ResponseEntity<Response> {
        val course = CourseConverter.convertToResponse(courseService.addBatch(course_id, start_year))
        val collegeResponse = Response()
                .success(true)
                .data(course)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }

    @GetMapping("/{courseId}")
    fun getById(@PathVariable("courseId", required = true) courseId: Int): ResponseEntity<Response> {
        val course = CourseConverter.convertToResponse(courseService.getById(courseId))
        val courseResponse = Response()
                .success(true)
                .data(course)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(courseResponse, HttpStatus.OK)
    }
}