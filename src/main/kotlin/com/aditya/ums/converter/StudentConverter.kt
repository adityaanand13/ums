package com.aditya.ums.converter

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.StudentResponse
import com.aditya.ums.api.response.UserResponse
import com.aditya.ums.entity.Student

class StudentConverter {
    companion object {
        fun convertToResponses(students: List<Student>): List<StudentResponse> {
            return students.map { student -> convertToResponse(student) }
        }

        fun convertToResponse(student: Student): StudentResponse {
            return StudentResponse(
                    localAddress = student.localAddress,
                    nationality = student.nationality,
                    fathersName = student.fathersName,
                    fathersPhone = student.fathersPhone,
                    fathersIncome = student.fathersIncome,
                    fathersOccupation = student.fathersOccupation,
                    mothersName = student.mothersName,
                    mothersPhone = student.mothersPhone,
                    mothersIncome = student.mothersIncome,
                    mothersOccupation = student.mothersOccupation,
                    familyIncome = student.familyIncome,
                    user = UserResponse(id = student.id,
                            username = student.username ?: "",
                            firstName = student.firstName,
                            lastName = student.lastName ?: "",
                            email = student.email,
                            DOB = student.DOB,
                            gender = student.gender,
                            phone = student.phone,
                            blood = student.blood,
                            religion = student.religion,
                            category = student.category,
                            aadhar = student.aadhar,
                            userType = student.userType,
                            address = student.address,
                            city = student.city,
                            state = student.state,
                            pinCode = student.pinCode,
                            country = student.country
                    )
            )
        }

        fun convertToEntity(studentRequest: StudentRequest): Student {
            val user = studentRequest.user
            return Student(
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
                    localAddress = studentRequest.localAddress,
                    nationality = studentRequest.nationality,
                    fathersName = studentRequest.fathersName,
                    fathersPhone = studentRequest.fathersPhone,
                    fathersIncome = studentRequest.fathersIncome,
                    fathersOccupation = studentRequest.fathersOccupation,
                    mothersName = studentRequest.mothersName,
                    mothersPhone = studentRequest.mothersPhone,
                    mothersIncome = studentRequest.mothersIncome ?: 0,
                    mothersOccupation = studentRequest.mothersOccupation,
                    familyIncome = studentRequest.familyIncome
            )
        }
    }

}