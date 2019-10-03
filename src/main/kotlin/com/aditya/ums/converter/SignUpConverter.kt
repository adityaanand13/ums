package com.aditya.ums.converter

import com.aditya.ums.api.payload.SignUpRequest
import com.aditya.ums.entity.User
import java.time.LocalDate

class SignUpConverter {
    companion object{
        fun convertToEntity(signUpRequest: SignUpRequest): User {
            return User(
                    username = signUpRequest.username,
                    password = signUpRequest.password,
                    firstName = signUpRequest.firstName,
                    lastName = signUpRequest.lastName,
                    email = signUpRequest.email
            )
        }
    }
}