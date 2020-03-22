package com.aditya.ums.converter

import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.api.response.UserResponse
import com.aditya.ums.entity.User

class UserConverter {
    companion object {
        fun convertToResponse(user: User) : UserResponse {
            return UserResponse(
                id = user.id,
                username = user.username ?: "",
                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email,
                DOB = user.DOB,
                gender = user.gender,
                phone = user.phone,
                blood = user.blood,
                religion = user.religion,
                category = user.category,
                aadhar = user.aadhar,
                userType = user.userType,
                address = user.address,
                city = user.city,
                state = user.state,
                pinCode = user.pinCode,
                country = user.country
            )
        }

        fun convertToEntity(userRequest: UserRequest): User{
            return User(
                username = userRequest.username,
                password = userRequest.password,
                firstName = userRequest.firstName,
                lastName = userRequest.lastName,
                email = userRequest.email,
                DOB = userRequest.DOB,
                gender = userRequest.gender,
                phone = userRequest.phone,
                blood = userRequest.blood,
                religion = userRequest.religion,
                category = userRequest.category,
                aadhar = userRequest.aadhar,
                userType = userRequest.userType,
                address = userRequest.address,
                city = userRequest.city,
                state = userRequest.state,
                pinCode = userRequest.pinCode,
                country = userRequest.country
            )
        }
    }
}