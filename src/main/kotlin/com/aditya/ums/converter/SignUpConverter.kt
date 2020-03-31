package com.aditya.ums.converter

import com.aditya.ums.api.request.SignUpRequest
import com.aditya.ums.entity.User

class SignUpConverter {
    companion object {
        fun convertToEntity(signUpRequest: SignUpRequest): User {
            return User(
                    username = signUpRequest.username,
                    password = signUpRequest.password,
                    firstName = signUpRequest.firstname,
                    lastName = signUpRequest.lastname,
                    email = signUpRequest.email,
                    DOB = signUpRequest.DOB,
                    gender = signUpRequest.gender,
                    phone = signUpRequest.phone
            )
        }
    }
}