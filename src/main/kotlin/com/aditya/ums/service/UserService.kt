package com.aditya.ums.service

import com.aditya.ums.api.request.CsvUserRequest
import com.aditya.ums.api.request.SignUpRequest
import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.api.response.CsvCreateResponse
import com.aditya.ums.api.response.CsvUserResponse
import com.aditya.ums.converter.CsvConverter
import com.aditya.ums.converter.SignUpConverter
import com.aditya.ums.converter.UserConverter
import com.aditya.ums.entity.Role
import com.aditya.ums.entity.User
import com.aditya.ums.enums.RoleType
import com.aditya.ums.enums.UserType
import com.aditya.ums.exception.BadRequestException
import com.aditya.ums.repository.RoleRepository
import com.aditya.ums.repository.UserRepository
import com.aditya.ums.validator.Validator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UserService(
        private val userRepository: UserRepository,
        private val roleRepository: RoleRepository,
        @Autowired private var passwordEncoder: PasswordEncoder
) {

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
                val user: User = CsvConverter.convertToUserEntity(request)
                user.password = passwordEncoder.encode(user.username+user.firstName)
                user.roles.add(roleRepository.findByName(RoleType.ROLE_USER))
                userRepository.save(user)
                val response: CsvUserResponse = CsvConverter.convertToResponse(request)
                responses.add(CsvCreateResponse(success, response, emptyList()))
            }else{
                val response: CsvUserResponse = CsvConverter.convertToResponse(request)
                responses.add(CsvCreateResponse(success, response ,errorMessage))
            }
        }
        return responses
    }

    //create user with limited details
    fun createUser(signUpRequest: SignUpRequest) : User{
        // todo validation
        val user = SignUpConverter.convertToEntity(signUpRequest)
        user.password = passwordEncoder.encode(user.password)
        user.roles.add(roleRepository.findByName(RoleType.ROLE_USER))
        return userRepository.save(user)
    }

    //create user with full detail
    fun createUser(userRequest: UserRequest) : User{
        //todo add  validation is done or not
        val user = UserConverter.convertToEntity(userRequest)
        user.password = passwordEncoder.encode(user.password)
        user.roles.add(roleRepository.findByName(RoleType.ROLE_USER))
        return userRepository.save(user)
    }

    fun createAdmin(userRequest: UserRequest): User {
        //todo validation
        val user = UserConverter.convertToEntity(userRequest = userRequest)
        user.password = passwordEncoder.encode(user.password)
        user.roles.add(roleRepository.findByName(RoleType.ROLE_ADMIN))
        user.userType = UserType.ADMIN
        return userRepository.save(user)
    }

    fun updateUser (userRequest: UserRequest): User{
        //todo validation
        if(userRequest.id == null || userRequest.firstName.isBlank() || userRequest.email.isBlank()) {
            throw BadRequestException("Invalid Request")
        }
        val user = UserConverter.convertToEntity(userRequest)
        return userRepository.save(user)
    }

    //only created by spring starter
    fun createSuperUser(pass: String):User{
        val password = passwordEncoder.encode(pass)
        val user = User(username = "superAdmin", firstName = "super", lastName = "admin", email = "superadmin@ums.com", password = password)
        enumValues<RoleType>().forEach {(roleRepository.save(Role(name  = it)))}
        user.roles = roleRepository.findAll()
        user.userType = UserType.SUPER
        return userRepository.save(user)
    }

    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    fun getAllAdmin(): List<User> {
        return userRepository.findAllByUserType(UserType.ADMIN)
    }

    fun searchByName(firstName: String) :User {
        return userRepository.findFirstByFirstName(firstName)
    }

    fun SearchByNameAndType(firstName: String, userType: UserType): User {
        return userRepository.findFirstByFirstNameAndUserType(firstName, userType)
    }

    fun isSuperAdmin():Boolean{
        return userRepository.existsByUsername("superAdmin")
    }

    fun getOneUser(id: Int) : User {
        return userRepository.getOne(id)
    }

    fun deleteOneUser (id: Int)  {
        userRepository.deleteById(id)
    }

}