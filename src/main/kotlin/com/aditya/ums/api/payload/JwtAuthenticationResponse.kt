package com.aditya.ums.api.payload

class JwtAuthenticationResponse(var accessToken: String?) {
    var tokenType = "Bearer"
}