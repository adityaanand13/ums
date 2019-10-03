package com.aditya.ums.api.controller

import com.aditya.ums.api.Response
import com.aditya.ums.api.payload.ApiResponse
import com.aditya.ums.api.payload.JwtAuthenticationResponse
import com.aditya.ums.api.payload.LoginRequest
import com.aditya.ums.api.payload.SignUpRequest
import com.aditya.ums.converter.SignUpConverter
import com.aditya.ums.entity.User
import com.aditya.ums.repository.UserRepository
import com.aditya.ums.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/admin")
public class AuthController(@Autowired var userRepository: UserRepository,
                            @Autowired var authenticationManager: AuthenticationManager,
                            @Autowired var passwordEncoder: PasswordEncoder,
                            @Autowired var tokenProvider: JwtTokenProvider) {

    @PostMapping("/signin")
    public fun  authenticateUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<JwtAuthenticationResponse> {

         val authentication = authenticationManager.authenticate( UsernamePasswordAuthenticationToken(
                        loginRequest.usernameOrEmail,
                        loginRequest.password
                )
        )

        SecurityContextHolder.getContext().authentication = authentication;

        val jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/addUser")
    fun registerUser(@Valid @RequestBody signUpRequest: SignUpRequest): ResponseEntity<ApiResponse>  {
        println("inside the function")
        if(signUpRequest.username.let { userRepository.existsByUsername(it) }) {
            return ResponseEntity(ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(signUpRequest.email.let { userRepository.existsByEmail(it) }!!) {
            return ResponseEntity(ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        val user = SignUpConverter.convertToEntity(signUpRequest)

        val location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(user.username).toUri()
        //result = returned user after saving
        System.out.println("user id getting returned")

        return ResponseEntity.created(location).body(ApiResponse(true, "User registered successfully"));
    }
}