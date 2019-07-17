package com.aditya.ums.api.controller

import com.aditya.ums.api.Response
import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.converter.SemesterConverter
import com.aditya.ums.service.SemesterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@ResponseBody
@RequestMapping("/api/semester")
class SemesterController (
        @Autowired private val semesterService: SemesterService
){
    @PostMapping("/{semester_id}/add-section")
    fun addSection(
            @PathVariable("semester_id", required = true) semester_id:Int,
            @Valid @RequestBody sectionRequest: SectionRequest
    ): ResponseEntity<Response> {
        val semester = SemesterConverter.convertToResponse(semesterService.addSection(semester_id, sectionRequest))
        val semesterResponse = Response()
                .success(true)
                .data(semester)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(semesterResponse, HttpStatus.OK)
    }
}