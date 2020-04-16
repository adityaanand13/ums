package com.aditya.ums.api.controller

import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.CollegeConverter
import com.aditya.ums.service.CollegeService
import com.aditya.ums.service.InstructorService
import com.aditya.ums.service.PrincipalService
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
        @Autowired private val instructorService: InstructorService,
        @Autowired private val principalService: PrincipalService
) {
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun getColleges(): ResponseEntity<Response>{
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
    fun postColleges(@Valid @RequestBody collegeRequest: CollegeRequest): ResponseEntity<Response>{
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
            @PathVariable("college_id", required = true) college_id:Int,
            @Valid @RequestBody courseRequest: CourseRequest
    ): ResponseEntity<Response>{
        val college = CollegeConverter.convertToResponse(collegeService.addCourse(college_id, courseRequest))
        val collegeResponse = Response()
                .success(true)
                .data(college)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(collegeResponse,HttpStatus.OK)
    }

    @PostMapping("/{college_id}/add-principal/{instructor_username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun addPrincipal(
            @PathVariable("college_id", required = true) college_id:Int,
            @PathVariable("instructor_username", required = true) instructor_username: String
    ): ResponseEntity<Response>{
        //todo college, instructor not found exception
        //todo refactor principal response
        val college = collegeService.getById(college_id)
        val instructor = instructorService.getByUsername(username = instructor_username)
        val principal = principalService.create(instructor,college)
        val collegeResponse = Response()
                .success(true)
                .data(principal)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(collegeResponse,HttpStatus.OK)
    }

    @GetMapping("/{collegeId}")
    fun getCollegeById(@PathVariable("collegeId", required = true) collegeId:Int): ResponseEntity<Response> {
        val college = CollegeConverter.convertToResponse(collegeService.getById(collegeId))
        val collegeResponse = Response()
                .success(true)
                .data(college)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }

    @PutMapping("/{collegeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun updateCollege(
            @PathVariable("collegeId", required = true) collegeId:Int,
            @Valid @RequestBody collegeRequest: CollegeRequest
    ): ResponseEntity<Response> {
        collegeRequest.id = collegeId
        val college = CollegeConverter.convertToResponse(collegeService.update(collegeRequest))
        val collegeResponse = Response()
                .success(true)
                .data(college)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{collegeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun deleteCollegeById(@PathVariable("collegeId", required = true) collegeId:Int): ResponseEntity<Response> {
        collegeService.deleteById(collegeId)
        val collegeResponse = Response()
                .success(true)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }
}