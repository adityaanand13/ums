package com.aditya.ums.api.controller

import com.aditya.ums.api.payload.ApiResponse
import com.aditya.ums.api.payload.JwtAuthenticationResponse
import com.aditya.ums.api.payload.LoginRequest
import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.converter.UserConverter
import com.aditya.ums.repository.RoleRepository
import com.aditya.ums.repository.StudentRepository
import com.aditya.ums.repository.UserRepository
import com.aditya.ums.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api/auth")
class AuthController {

    @Autowired
    internal var authenticationManager: AuthenticationManager? = null

    @Autowired
    internal var userRepository: UserRepository? = null

    @Autowired
    internal var studentRepository: StudentRepository? = null

    @Autowired
    internal var roleRepository: RoleRepository? = null

    @Autowired
    internal var passwordEncoder: PasswordEncoder? = null

    @Autowired
    internal var tokenProvider: JwtTokenProvider? = null

    @PostMapping("/signin")
    fun authenticateUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<*> {

        val authentication = authenticationManager!!.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginRequest.usernameOrEmail,
                        loginRequest.password
                )
        )

        SecurityContextHolder.getContext().authentication = authentication

        val jwt = tokenProvider!!.generateToken(authentication)
        return ResponseEntity.ok<Any>(JwtAuthenticationResponse(jwt))
    }

    @PostMapping("/signup")
    fun registerUser(@Valid @RequestBody signUpRequest: UserRequest): ResponseEntity<*> {
        if (userRepository!!.existsByUsername(signUpRequest.username)) {
            return ResponseEntity(ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST)
        }

        if (userRepository!!.existsByEmail(signUpRequest.email)!!) {
            return ResponseEntity(ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST)
        }

        // Creating user's account -- STUDENT
        val user = UserConverter.convertToEntity(userRequest = signUpRequest)

        user.password = passwordEncoder!!.encode(user.password)

//        val userRole = roleRepository!!.findByName(RoleName.ROLE_USER)
//                .orElseThrow { AppException("User Role not set.") }

//        user.roles = mutableSetOf<Role>(userRole)

        val result = userRepository!!.save(user)

        val location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.username).toUri()

        return ResponseEntity.created(location).body<Any>(ApiResponse(true, "User registered successfully"))
    }
}
