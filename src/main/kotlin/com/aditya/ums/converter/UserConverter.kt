package com.aditya.ums.converter

import com.aditya.ums.api.response.UserResponse
import com.aditya.ums.entity.User

class UserConverter {
    companion object {
        fun convertToResponse(user: User) : UserResponse {
            return UserResponse(
                id = user.id,
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
    }
}