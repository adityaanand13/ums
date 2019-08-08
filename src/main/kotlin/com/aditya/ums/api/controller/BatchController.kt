package com.aditya.ums.api.controller

import com.aditya.ums.api.Response
import com.aditya.ums.api.request.SemesterRequest
import com.aditya.ums.converter.BatchConverter
import com.aditya.ums.service.BatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@ResponseBody
@RequestMapping("/api/batch")
class BatchController(
        @Autowired private val batchService: BatchService
) {
    @GetMapping("/")
    fun getAll():ResponseEntity<Response>{
        val batches = BatchConverter.convertToResponses(batchService.getAll())
        val batchesResponse = Response()
                .success(true)
                .data(batches)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(batchesResponse, HttpStatus.OK)
    }

    @PostMapping("/{batchId}/add-semester")
    fun addSection(
            @PathVariable("batchId", required = true) batchId:Int,
            @Valid @RequestBody semesterRequest: SemesterRequest
    ): ResponseEntity<Response> {
        val batch = BatchConverter.convertToResponse(batchService.addSemester(batchId, semesterRequest))
        val semesterResponse = Response()
                .success(true)
                .data(batch)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(semesterResponse, HttpStatus.OK)
    }

    @GetMapping("/{batchId}")
    fun getById(@PathVariable("batchId", required = true) batchId:Int): ResponseEntity<Response> {
        val batch = BatchConverter.convertToResponse(batchService.getById(batchId))
        val batchResponse = Response()
                .success(true)
                .data(batch)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(batchResponse, HttpStatus.OK)
    }

}