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
            return Instructor(
                    username = instructorRequest.username,
                    firstName = instructorRequest.firstName,
                    lastName = instructorRequest.lastName,
                    email = instructorRequest.email,
                    password = instructorRequest.password,
                    DOB = instructorRequest.DOB,
                    gender = instructorRequest.gender,
                    phone = instructorRequest.phone,
                    blood = instructorRequest.blood,
                    religion = instructorRequest.religion,
                    category = instructorRequest.category,
                    aadhar = instructorRequest.aadhar,
                    address = instructorRequest.address,
                    city = instructorRequest.city,
                    state = instructorRequest.state,
                    pinCode = instructorRequest.pinCode,
                    country = instructorRequest.country
            )
        }
    }
}