package com.aditya.ums.api.controller

import com.aditya.ums.api.Response
import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.converter.CollegeConverter
import com.aditya.ums.service.CollegeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/api/college")
@ResponseBody
class CollegeController(
        @Autowired private val collegeService: CollegeService
) {
    @GetMapping("/")
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
    fun updateCollege(
            @PathVariable("collegeId", required = true) collegeId:Int,
            @Valid @RequestBody collegeRequest: CollegeRequest
    ): ResponseEntity<Response> {
        collegeRequest.id = collegeId;
        val college = CollegeConverter.convertToResponse(collegeService.update(collegeRequest))
        val collegeResponse = Response()
                .success(true)
                .data(college)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{collegeId}")
    fun deleteCollegeById(@PathVariable("collegeId", required = true) collegeId:Int): ResponseEntity<Response> {
        collegeService.deleteById(collegeId)
        val collegeResponse = Response()
                .success(true)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(collegeResponse, HttpStatus.OK)
    }
}