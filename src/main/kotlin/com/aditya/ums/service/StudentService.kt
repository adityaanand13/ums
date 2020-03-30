package com.aditya.ums.service

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.converter.StudentConverter
import com.aditya.ums.entity.Student
import com.aditya.ums.enums.UserType
import com.aditya.ums.exception.BadRequestException
import com.aditya.ums.repository.RoleRepository
import com.aditya.ums.repository.StudentRepository
import com.aditya.ums.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@Service
class StudentService(
        private val userService: UserService,
        private val studentRepository: StudentRepository,
        private val userRepository: UserRepository,
        var passwordEncoder: PasswordEncoder,
        var roleRepository: RoleRepository
) {
    //returns list of all the students in the DB
    fun getAll(): List<Student> {
        return studentRepository.findAll()
    }

    fun create(studentRequest: StudentRequest): Student {
        if (userRepository.existsByUsername(studentRequest.user.username)) {
            throw BadRequestException("Username is already taken!")
        }

        if (userRepository.existsByEmail(studentRequest.user.email)) {
            throw BadRequestException("Email Address already in use!")
        }

        // Creating user's account -- STUDENT
        val user = StudentConverter.convertToEntity(studentRequest = studentRequest)

        user.password = passwordEncoder.encode(user.password)

//        val userRole = roleRepository.findByName("ROLE_USER")

//        if (userRole != null) {
//            user.roles.add(userRole)
//        }

        val result = studentRepository.save(user)

        val location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.username).toUri()

        return user
    }

    fun searchByName(firstName: String): Student {
        return studentRepository.findFirstByFirstNameAndUserType(firstName, UserType.STUDENT)
    }
}