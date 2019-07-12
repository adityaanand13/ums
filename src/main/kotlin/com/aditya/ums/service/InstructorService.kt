package com.aditya.ums.service

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.api.response.InstructorResponse
import com.aditya.ums.converter.InstructorConverter
import com.aditya.ums.entity.Instructor
import com.aditya.ums.entity.User
import com.aditya.ums.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class InstructorService (
        private val userService: UserService,
        private val instructorRepository: InstructorRepository
){
    //returns list of all the instructors in the DB
    fun getAll(): List<InstructorResponse> {
        return InstructorConverter.convertToResponses(instructorRepository.findAll())
    }

    fun create(instructorRequest: InstructorRequest) : Instructor {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        val user: User = userService.createUser(instructorRequest.user)
        return instructorRepository.
            save(
                InstructorConverter.convertToEntity(instructorRequest, user)
            )
    }
}
