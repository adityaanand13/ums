package com.aditya.ums.service

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.StudentResponse
import com.aditya.ums.converter.StudentConverter
import com.aditya.ums.entity.Student
import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import com.aditya.ums.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService (
        private val userService: UserService,
        private val studentRepository: StudentRepository
){
    //returns list of all the students in the DB
    fun getAll(): List<StudentResponse> {
        return StudentConverter.convertToResponses(studentRepository.findAll())
    }

    fun create(studentRequest: StudentRequest) : Student {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        val user: User = userService.createUser(studentRequest.user)
        return studentRepository.
            save(
                StudentConverter.convertToEntity(
                    studentRequest,
                    user
                )
            )
    }

    fun searchByName(firstName: String): Student {
        return studentRepository.
                findFirstByUserFirstNameAndUserUserType(firstName, UserType.STUDENT)
    }
}