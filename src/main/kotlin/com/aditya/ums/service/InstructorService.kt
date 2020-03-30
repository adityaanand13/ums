package com.aditya.ums.service

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.converter.InstructorConverter
import com.aditya.ums.entity.Instructor
import com.aditya.ums.enums.UserType
import com.aditya.ums.repository.InstructorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class InstructorService(
        private val userService: UserService,
        private val instructorRepository: InstructorRepository,
        private val courseService: CourseService,
        @Autowired private var passwordEncoder: PasswordEncoder
) {
    //returns list of all the instructors in the DB
    fun getAll(): List<Instructor> {
        return instructorRepository.findAll()
    }

    fun create(instructorRequest: InstructorRequest): Instructor {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        val instructor = InstructorConverter.convertToEntity(instructorRequest)
        instructor.password = passwordEncoder.encode(instructor.password)
        return instructorRepository.save(instructor)
    }

    fun searchByName(firstName: String): Instructor {
        return instructorRepository.findFirstByFirstNameAndUserType(firstName, UserType.INSTRUCTOR)
    }

    fun getByEmployeeID(employeeID: Int): Instructor {
        return instructorRepository.findFirstByEmployeeID(employeeID)
    }
}
