package com.aditya.ums.service

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.converter.InstructorConverter
import com.aditya.ums.entity.Instructor
import com.aditya.ums.enums.RoleType
import com.aditya.ums.enums.UserType
import com.aditya.ums.repository.InstructorRepository
import com.aditya.ums.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class InstructorService(
        @Autowired private val userService: UserService,
        @Autowired private val instructorRepository: InstructorRepository,
        @Autowired private val courseService: CourseService,
        @Autowired private val passwordEncoder: PasswordEncoder,
        @Autowired private val roleRepository: RoleRepository
) {
    //returns list of all the instructors in the DB
    fun getAll(): List<Instructor> {
        return instructorRepository.findAll()
    }

    fun createInstructor(instructorRequest: InstructorRequest): Instructor {
        val instructor = InstructorConverter.convertToEntity(instructorRequest)
        instructor.password = passwordEncoder.encode(instructor.password)
        instructor.roles.add(roleRepository.findByName(RoleType.ROLE_INSTRUCTOR))
        return instructorRepository.save(instructor)
    }

    fun getByUsername(username: String): Instructor {
        return instructorRepository.findByUsername(username)
    }

    fun searchByName(firstName: String): Instructor {
        return instructorRepository.findFirstByFirstNameAndUserType(firstName, UserType.INSTRUCTOR)
    }

//    fun getByEmployeeID(employeeID: Int): Instructor {
//        return instructorRepository.findFirstByEmployeeID(employeeID)
//    }
}
