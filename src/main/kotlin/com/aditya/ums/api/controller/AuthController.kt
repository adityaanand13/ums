package com.aditya.ums.api.controller

import com.aditya.ums.api.payload.JwtAuthenticationResponse
import com.aditya.ums.api.payload.LoginRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.converter.UserConverter

import com.aditya.ums.repository.RoleRepository
import com.aditya.ums.repository.StudentRepository
import com.aditya.ums.repository.UserRepository
import com.aditya.ums.security.JwtTokenProvider
import com.aditya.ums.service.UserService
import io.swagger.annotations.Authorization
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/auth")
class AuthController(
        @Autowired private var authenticationManager: AuthenticationManager,
        @Autowired private var userService: UserService,
        @Autowired private var userRepository: UserRepository,
        @Autowired private var studentRepository: StudentRepository,
        @Autowired private var roleRepository: RoleRepository,
        @Autowired private var tokenProvider: JwtTokenProvider
) {

    @PostMapping("/login")
    fun authenticateUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<*> {

        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginRequest.usernameOrEmail,
                        loginRequest.password
                )
        )

        SecurityContextHolder.getContext().authentication = authentication

        val jwt = tokenProvider.generateToken(authentication)
        return ResponseEntity.ok<Any>(JwtAuthenticationResponse(jwt))
    }

    @GetMapping("/verify")
    fun verify(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }

    //to be moved to admin
//    @PostMapping("/signup")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    fun registerUser(@Valid @RequestBody signUpRequest: SignUpRequest): ResponseEntity<Response> {
//        if (userRepository.existsByUsername(signUpRequest.username)) {
//            return ResponseEntity(Response()
//                    .success(false)
//                    .data(signUpRequest.username)
//                    .statusMessage("Username Already In use")
//                    .httpStatusCode(HttpStatus.BAD_REQUEST.value()),
//                    HttpStatus.BAD_REQUEST)
//        }
//
//        if (userRepository.existsByEmail(signUpRequest.email)) {
//            return ResponseEntity(Response()
//                    .success(false)
//                    .data(signUpRequest.email)
//                    .statusMessage("Email Already In use")
//                    .httpStatusCode(HttpStatus.BAD_REQUEST.value()),
//                    HttpStatus.BAD_REQUEST)
//        }
//        // Creating default user's account --
//        val user = SignUpConverter.convertToEntity(signUpRequest = signUpRequest)
//
//        val result = userService.createUser(signUpRequest)
//
//        val response = Response()
//                .success(true)
//                .httpStatusCode(HttpStatus.OK.value())
//                .statusMessage("User registered successfully")
//        return ResponseEntity(response, HttpStatus.OK)
//    }
}
