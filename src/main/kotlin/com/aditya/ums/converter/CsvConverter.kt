package com.aditya.ums.converter

import com.aditya.ums.api.request.CsvUserRequest
import com.aditya.ums.api.response.CsvUserResponse
import com.aditya.ums.entity.Student
import com.aditya.ums.entity.User
import com.aditya.ums.enums.Gender
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CsvConverter () {
    companion object {
        fun convertToUserEntity(csvUserRequest: CsvUserRequest): User {
            return User(
                username = csvUserRequest.username,
                firstName = csvUserRequest.firstname,
                lastName = csvUserRequest.lastname,
                email = csvUserRequest.email,
                DOB = LocalDate.parse(csvUserRequest.DOB, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                gender = Gender.valueOf(csvUserRequest.gender),
                phone = csvUserRequest.phone,
                country = csvUserRequest.country,
                aadhar = csvUserRequest.aadhar,
                password = ""
            )
        }

        fun convertToStudentEntity(csvUserRequest: CsvUserRequest): Student {
            return Student(
                    username = csvUserRequest.username,
                    firstName = csvUserRequest.firstname,
                    lastName = csvUserRequest.lastname,
                    email = csvUserRequest.email,
                    DOB = LocalDate.parse(csvUserRequest.DOB, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    gender = Gender.valueOf(csvUserRequest.gender),
                    phone = csvUserRequest.phone,
                    country = csvUserRequest.country,
                    aadhar = csvUserRequest.aadhar,
                    password = ""
            )
        }

        fun convertToResponse(csvUserRequest: CsvUserRequest): CsvUserResponse {
            return CsvUserResponse(
                username = csvUserRequest.username,
                email = csvUserRequest.email,
                firstName = csvUserRequest.firstname,
                lastName = csvUserRequest.lastname,
                gender = csvUserRequest.gender,
                DOB = csvUserRequest.DOB,
                phone = csvUserRequest.phone,
                country = csvUserRequest.country
            )
        }
    }
}