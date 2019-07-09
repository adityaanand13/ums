package com.aditya.ums.api.response

class UserResponse (
        val id: Int,
        val firstName: String,
        val lastName: String? = null,
        val email: String
)