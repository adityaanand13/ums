package com.aditya.ums.api.controller

import com.aditya.ums.api.payload.ApiResponse
import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.UserConverter
import com.aditya.ums.entity.User
import com.aditya.ums.security.UserPrincipal
import com.aditya.ums.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
@ResponseBody
class UserController(
        @Autowired private val userService: UserService
) {

    @GetMapping("/")
    fun getMyProfile(): ResponseEntity<Response>{
        val user = SecurityContextHolder.getContext().authentication.principal as UserPrincipal
        print(userService.getOneUser(user.id).id)
        val userResponse = UserConverter.convertToResponse(userService.getOneUser(user.id))
        val response = Response()
                .success(true)
                .data(userResponse)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(response, HttpStatus.OK)
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
        val userResponse = UserConverter.convertToResponse(user)
        val usersResponse = Response()
                .success(true)
                .data(userResponse)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    //search a user by id
    @GetMapping("user/search-id/{id}")
    fun getUser(@PathVariable("id", required = true) id: Int): ResponseEntity<*>{
        val user = userService.getOneUser(id)

        if (user==null){
            return ResponseEntity(ApiResponse(false, "User Not Found"),
                    HttpStatus.BAD_REQUEST)
        }

        val usersResponse = Response()
                .success(true)
                .data(user)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    //warning only admins allowed
    //special privilege only for admins, only admin can create new user
//    @PreAuthorize("hasAuthority('Admin')")
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

    //special privilege only for admins, only admin can get list of all users
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    fun getUsers(): ResponseEntity<Response> {
        val users =  UserConverter.convertToResponses(userService.getAll())

        val usersResponse = Response()
                .success(true)
                .data(users)
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }

    //special privilege only for admins, only admin can delete a new user
    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable("id", required = true) id: Int): ResponseEntity<Response>{
        userService.deleteOneUser(id)
        val usersResponse = Response()
                .success(true)
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(usersResponse, HttpStatus.OK)
    }
}