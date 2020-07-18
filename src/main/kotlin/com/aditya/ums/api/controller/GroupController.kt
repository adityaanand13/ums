package com.aditya.ums.api.controller

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.GroupConverter
import com.aditya.ums.service.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/group")
@ResponseBody
class GroupController(
        @Autowired private val groupService: GroupService
) {
    @PostMapping("/{group_id}/add-student")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun addStudent(
            @PathVariable group_id: Int,
            @Valid @RequestBody studentRequest: StudentRequest
    ): ResponseEntity<Response> {
        val groupResponse = GroupConverter.convertToDetailedResponse(groupService.addStudent(group_id, studentRequest))
        val response = Response()
                .success(true)
                .data(groupResponse)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{group_id}")
    fun getGroup(@PathVariable group_id: Int): ResponseEntity<Response>{
        val groupResponse = GroupConverter.convertToResponse(groupService.getById(group_id))
        val response = Response()
                .success(true)
                .data(groupResponse)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{group_id}/detailed")
    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    fun getStudents(@PathVariable group_id: Int): ResponseEntity<Response> {
        val groupResponse = GroupConverter.convertToDetailedResponse(groupService.getById(group_id))
        val response = Response()
                .success(true)
                .data(groupResponse)
                .contentType("/application/json")
                .httpStatusCode(HttpStatus.OK.value())
                .statusMessage("Success")
        return ResponseEntity(response, HttpStatus.OK)
    }
}