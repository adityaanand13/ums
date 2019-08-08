//package com.aditya.ums.api.controller
//
//import com.aditya.ums.JwtTokenUtil
//import com.aditya.ums.api.request.JwtRequest
//import com.aditya.ums.api.response.JwtResponse
//import com.aditya.ums.service.JwtUserDetailsService
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.BadCredentialsException
//import org.springframework.security.authentication.DisabledException
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@CrossOrigin
//class JwtAuthenticationController(
//        @Autowired private val authenticationManager: AuthenticationManager,
//        @Autowired private val jwtTokenUtil: JwtTokenUtil,
//        @Autowired private val userDetailsService: JwtUserDetailsService
//
//) {
//    @PostMapping("/authenticate")
//    @Throws(Exception::class)
//    private fun createAuthenticationToken(@RequestBody authenticationRequest: JwtRequest): ResponseEntity<> {
//
//        authenticate(authenticationRequest.username, authenticationRequest.password);
//
//        val userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.username);
//
//         val token = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(JwtResponse(token));
//    }
//
//    private fun authenticate(username: String? = null, password: String? = null){
//        try {
//            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password));
//        } catch (e: DisabledException) {
//            throw Exception("USER_DISABLED", e);
//        } catch (e: BadCredentialsException) {
//            throw Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//}