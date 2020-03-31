package com.aditya.ums.converter

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.api.response.InstructorResponse
import com.aditya.ums.api.response.UserResponse
import com.aditya.ums.entity.Instructor

class InstructorConverter {
    companion object {
        fun convertToResponses(instructors: List<Instructor>): List<InstructorResponse> {
            return instructors.map { instructor -> convertToResponse(instructor) }
        }

        fun convertToResponse(instructor: Instructor): InstructorResponse {
            return InstructorResponse(
                    employeeID = instructor.employeeID,
                    user = UserResponse(
                            id = instructor.id,
                            username = instructor.username ?: "",
                            firstName = instructor.firstName,
                            lastName = instructor.lastName ?: "",
                            email = instructor.email,
                            DOB = instructor.DOB,
                            gender = instructor.gender,
                            phone = instructor.phone,
                            blood = instructor.blood,
                            religion = instructor.religion,
                            category = instructor.category,
                            aadhar = instructor.aadhar,
                            userType = instructor.userType,
                            address = instructor.address,
                            city = instructor.city,
                            state = instructor.state,
                            pinCode = instructor.pinCode,
                            country = instructor.country
                    )
            )
        }

        fun convertToEntity(instructorRequest: InstructorRequest): Instructor {
            val user = instructorRequest.user
            return Instructor(
                    username = user.username,
                    firstName = user.firstName,
                    lastName = user.lastName,
                    email = user.email,
                    password = user.password,
                    DOB = user.DOB,
                    gender = user.gender,
                    phone = user.phone,
                    blood = user.blood,
                    religion = user.religion,
                    category = user.category,
                    aadhar = user.aadhar,
                    address = user.address,
                    city = user.city,
                    state = user.state,
                    pinCode = user.pinCode,
                    country = user.country,
                    employeeID = instructorRequest.employeeID
            )
        }
    }
}