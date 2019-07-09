package com.aditya.ums.api.controller

import com.aditya.ums.api.MetaType
import com.aditya.ums.api.Response
import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
@ResponseBody
class UserController(
        @Autowired private val userService: UserService
) {

    @GetMapping("/")
    fun getUsers(): ResponseEntity<Response> {
        val users =  userService.getAll()
        val usersResponse = Response()
                .success(true)
                .data(users)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    @PostMapping("/")
    fun postUser(@Valid @RequestBody userRequest: UserRequest) : ResponseEntity<Response> {
        val user = userService.createUser(userRequest)
        val usersResponse = Response()
                .success(true)
                .data(user)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id", required = true) id: Int): ResponseEntity<Response>{
        userService.deleteOneUser(id)
        val usersResponse = Response()
                .success(true)
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    @PutMapping("/")
    fun updateUser(@Valid @RequestBody userRequest: UserRequest) : ResponseEntity<Response> {
        val user = userService.updateUser(userRequest)
        val usersResponse = Response()
                .success(true)
                .data(user)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    @GetMapping("/search-firstname/{firstName}")
    fun searchByFirstName(@PathVariable("firstName", required = true) firstName: String): ResponseEntity<Response>{
        val user = userService.searchByName(firstName)
        val usersResponse = Response()
                .success(true)
                .data(user)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }
}