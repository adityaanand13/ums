package com.aditya.ums.api.controller

import com.aditya.ums.api.payload.JwtAuthenticationResponse
import com.aditya.ums.api.payload.LoginRequest
import com.aditya.ums.api.response.Response
import com.aditya.ums.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/auth")
class AuthController(
        @Autowired private var authenticationManager: AuthenticationManager,
        @Autowired private var tokenProvider: JwtTokenProvider
) {

    @PostMapping("/login")
    fun authenticateUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<Response> {

        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginRequest.usernameOrEmail,
                        loginRequest.password
                )
        )

        SecurityContextHolder.getContext().authentication = authentication

        val jwt = tokenProvider.generateToken(authentication)
        val response = Response()
                .success(true)
                .data(JwtAuthenticationResponse(jwt))
                .contentType("application/json")
                .httpStatusCode(HttpStatus.OK.value()).statusMessage("success")
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/verify")
    fun verify(): ResponseEntity<Any> {
        return ResponseEntity(
                mapOf("data" to mapOf("valid" to true)),
                HttpStatus.OK)
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
