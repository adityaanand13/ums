package com.aditya.ums.api.controller

import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.api.response.PrincipalAssignResponse
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.CollegeConverter
import com.aditya.ums.converter.InstructorConverter
import com.aditya.ums.entity.College
import com.aditya.ums.service.CollegeService
import com.aditya.ums.service.InstructorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/api/college")
@ResponseBody
class CollegeController(
        @Autowired private val collegeService: CollegeService,
        @Autowired private val instructorService: InstructorService
) {
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun getColleges(): ResponseEntity<Response> {
        val colleges = CollegeConverter.convertToResponses(collegeService.getAll())
        val collegesResponse = Response()
                .success(true)
                .data(colleges)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(collegesResponse, HttpStatus.OK)
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun postColleges(@Valid @RequestBody collegeRequest: CollegeRequest): ResponseEntity<Response> {
        val college = CollegeConverter.convertToResponse(collegeService.create(collegeRequest))
        val collegeResponse = Response()
                .success(true)
                .data(college)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }

    @PostMapping("/{college_id}/add-course")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun addCourse(
            @PathVariable("college_id", required = true) college_id: Int,
            @Valid @RequestBody courseRequest: CourseRequest
    ): ResponseEntity<Response> {
        val college = collegeService.addCourse(college_id, courseRequest)
        val principal = college.collegePrincipal?.principal?.let { instructorService.getById(it) }
        val collegeResponse = CollegeConverter.convertToDetailedResponse(college = college, principal = principal)
        val response = Response()
                .success(true)
                .data(collegeResponse)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/{college_id}/add-principal/{instructor_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun addPrincipal(
            @PathVariable("college_id", required = true) college_id: Int,
            @PathVariable("instructor_id", required = true) instructor_id: Int
    ): ResponseEntity<Response> {
        val college: College = collegeService.assignPrincipal(college_id, instructor_id)
        val principal = college.collegePrincipal?.principal?.let {
            InstructorConverter.convertToResponse(
                    instructorService.getById(it)
            )
        }
        val collegeResponse = Response()
                .success(true)
                .data(PrincipalAssignResponse(id = college.id!!, principal = principal!!))
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }

    @GetMapping("/{collegeId}")
    fun getCollegeById(@PathVariable("collegeId", required = true) collegeId: Int): ResponseEntity<Response> {
        val college = collegeService.getById(collegeId)
        val principal = college.collegePrincipal?.principal?.let { instructorService.getById(it) }
        val collegeResponse = CollegeConverter.convertToDetailedResponse(college = college, principal = principal)
        val response = Response()
                .success(true)
                .data(collegeResponse)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun updateCollege(@Valid @RequestBody collegeRequest: CollegeRequest): ResponseEntity<Response> {
        val college = collegeService.update(collegeRequest)
        val principal = college.collegePrincipal?.principal?.let { instructorService.getById(it) }
        val collegeResponse = CollegeConverter.convertToDetailedResponse(college = college, principal = principal)
        val response = Response()
                .success(true)
                .data(collegeResponse)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(response, HttpStatus.OK)
    }

    @DeleteMapping("/{collegeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun deleteCollegeById(@PathVariable("collegeId", required = true) collegeId: Int): ResponseEntity<Response> {
        collegeService.deleteById(collegeId)
        val collegeResponse = Response()
                .success(true)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }
}