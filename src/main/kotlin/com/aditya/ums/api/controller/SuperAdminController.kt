package com.aditya.ums.api.controller

import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.UserConverter
import com.aditya.ums.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/super")
@ResponseBody
class SuperAdminController(
        @Autowired private val userService: UserService){

    @PostMapping("/addAdmin")
    @PreAuthorize("hasRole('ROLE_SUPER')")
    fun addAdmin(@Valid @RequestBody userRequest: UserRequest) : ResponseEntity<Response> {
        val user = userService.createAdmin(userRequest)
        val userResponse = UserConverter.convertToResponse(user)
        val usersResponse = Response()
                .success(true)
                .data(userResponse)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    @GetMapping("/all")
    fun getAdmin(): ResponseEntity<Response> {
        val users =  UserConverter.convertToResponses(userService.getAllAdmin())

        val usersResponse = Response()
                .success(true)
                .data(users)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }
}