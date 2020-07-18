package com.aditya.ums.converter

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.StudentResponse
import com.aditya.ums.entity.Student

class StudentConverter {
    companion object {
        fun convertToResponses(students: List<Student>): List<StudentResponse> {
            return students.map { student -> convertToResponse(student) }
        }

        fun convertToResponse(student: Student): StudentResponse {
            return StudentResponse(
                    id = student.id,
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
                    username = student.username ?: "",
                    firstName = student.firstName,
                    lastName = student.lastName ?: "",
                    email = student.email,
                    dob = student.DOB,
                    gender = student.gender,
                    phone = student.phone,
                    blood = student.blood,
                    religion = student.religion,
                    category = student.category,
                    aadhar = student.aadhar,
                    address = student.address,
                    city = student.city,
                    state = student.state,
                    pinCode = student.pinCode,
                    country = student.country
            )
        }

        fun convertToEntity(studentRequest: StudentRequest): Student {
            return Student(
                    id = studentRequest.id,
                    username = studentRequest.username,
                    firstName = studentRequest.firstName,
                    lastName = studentRequest.lastName,
                    email = studentRequest.email,
                    password = studentRequest.password,
                    DOB = studentRequest.dob,
                    gender = studentRequest.gender,
                    phone = studentRequest.phone,
                    blood = studentRequest.blood,
                    religion = studentRequest.religion,
                    category = studentRequest.category,
                    aadhar = studentRequest.aadhar,
                    address = studentRequest.address,
                    city = studentRequest.city,
                    state = studentRequest.state,
                    pinCode = studentRequest.pinCode,
                    country = studentRequest.country,
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