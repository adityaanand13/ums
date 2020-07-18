package com.aditya.ums.api.controller

import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.SectionConverter
import com.aditya.ums.service.SectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@ResponseBody
@RequestMapping("/api/section")
class SectionController(
        @Autowired private val sectionService: SectionService
) {
    @GetMapping("/{sectionId}")
    fun getById(@PathVariable("sectionId", required = true) sectionId:Int): ResponseEntity<Response> {
        val section = SectionConverter.convertToResponse(sectionService.getById(sectionId))
        val sectionResponse = Response()
                .success(true)
                .data(section)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(sectionResponse, HttpStatus.OK)
    }

    @PostMapping("/{sectionId}/add-group")
    fun addGroup(
            @PathVariable("sectionId", required = true) sectionId:Int
    ): ResponseEntity<Response> {
        val section = SectionConverter.convertToResponse(sectionService.addGroup(sectionId))
        val sectionResponse = Response()
                .success(true)
                .data(section)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(sectionResponse, HttpStatus.OK)
    }
}