package com.aditya.ums.service

import com.aditya.ums.api.request.CsvUserRequest
import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.CsvCreateResponse
import com.aditya.ums.api.response.CsvUserResponse
import com.aditya.ums.converter.CsvConverter
import com.aditya.ums.converter.StudentConverter
import com.aditya.ums.entity.Student
import com.aditya.ums.enums.RoleType
import com.aditya.ums.enums.UserType
import com.aditya.ums.exception.BadRequestException
import com.aditya.ums.repository.RoleRepository
import com.aditya.ums.repository.StudentRepository
import com.aditya.ums.repository.UserRepository
import com.aditya.ums.validator.Validator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
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
        if (userRepository.existsByUsername(studentRequest.username)) {
            throw BadRequestException("Username is already taken!")
        }

        if (userRepository.existsByEmail(studentRequest.email)) {
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

    //create multiple default user using csv
    //todo refactor added by, college, class, batch, section, group
    fun createUserByCsv(file: MultipartFile): MutableSet<CsvCreateResponse> {
        val requests: MutableSet<CsvUserRequest> = CsvParserService.parseUserCsvToEntity(file)
        val responses: MutableSet<CsvCreateResponse> = mutableSetOf()

        for(request in requests){
            var success: Boolean = true
            val errorMessage: MutableList<String> = mutableListOf()
            // validation
            if(request.firstname.isBlank() || request.lastname.isBlank()) {
                success = false
                errorMessage.add("Names can't be empty")
            }
            if (userRepository.existsByUsername(request.username)){
                success = false
                errorMessage.add("Username already Exists")
            }
            if(Validator.isEmailValid(request.email)){
                if (userRepository.existsByEmail(request.email)){
                    success = false
                    errorMessage.add("email already in use")
                }
            }else{
                success = false
                errorMessage.add("invalid email format")
            }
            //todo refactor due to error
//            if (Gender.values().any{ it.name == request.gender }){
//                success = false
//                errorMessage.add("Only use MALE, FEMALE, TRANSGENDER, UNDEFINED")
//            }
//            if (Validator.isDateValid(request.DOB)){
//                success = false
//                errorMessage.add("Invalid date, use format yyyy-MM-dd")
//            }
            //India as default country
            if (request.country.isBlank()){
                request.country = "India"
            }
            //when passed all validation
            if(success){
                val student: Student = CsvConverter.convertToStudentEntity(request)
                student.password = passwordEncoder.encode(student.username+student.firstName)
                student.roles.add(roleRepository.findByName(RoleType.ROLE_STUDENT))
                studentRepository.save(student)
                val response: CsvUserResponse = CsvConverter.convertToResponse(request)
                responses.add(CsvCreateResponse(success, response, emptyList()))
            }else{
                val response: CsvUserResponse = CsvConverter.convertToResponse(request)
                responses.add(CsvCreateResponse(success, response ,errorMessage))
            }
        }
        return responses
    }

    fun searchByName(firstName: String): Student {
        return studentRepository.findFirstByFirstNameAndUserType(firstName, UserType.STUDENT)
    }
}