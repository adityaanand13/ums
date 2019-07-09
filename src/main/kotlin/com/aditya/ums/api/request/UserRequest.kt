package com.aditya.ums.api.request

class UserRequest (
        val id: Int? = null,
        val firstName: String,
        val lastName: String? = null,
        val email: String
)