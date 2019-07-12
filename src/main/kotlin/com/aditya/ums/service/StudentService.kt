package com.aditya.ums.service

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.StudentResponse
import com.aditya.ums.converter.StudentConverter
import com.aditya.ums.entity.Student
import com.aditya.ums.entity.User
import com.aditya.ums.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService (
        private val userService: UserService,
        private val studentRepository: StudentRepository
){
    //returns list of all the students in the DB
    fun getAll(): List<StudentResponse> {
        var studentResponses : List<StudentResponse>
        studentResponses = ArrayList()

        for (student in studentRepository.findAll())
            studentResponses.add(StudentConverter.convertToResponse(student))

        return studentResponses
    }

    fun create(studentRequest: StudentRequest) : Student {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        val user: User = userService.createUser(studentRequest.user)
        val student = Student(
            user = user,
            rollNo = studentRequest.rollNo,
            batch = studentRequest.batch,
            localAddress = studentRequest.localAddress,
            nationality = studentRequest.nationality,
            fathersName = studentRequest.fathersName,
            fathersPhone = studentRequest.fathersPhone,
            fathersIncome = studentRequest.fathersIncome,
            fathersOccupation = studentRequest.fathersOccupation,
            mothersName = studentRequest.mothersName,
            mothersPhone = studentRequest.mothersPhone,
            mothersIncome = studentRequest.mothersIncome,
            mothersOccupation = studentRequest.mothersOccupation,
            familyIncome = studentRequest.familyIncome
        )
        return studentRepository.save(student)
    }
}