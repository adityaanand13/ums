package com.aditya.ums.service

import com.aditya.ums.api.BadRequestException
import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.converter.UserConverter
import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import com.aditya.ums.repository.UserRepository
import com.aditya.ums.security.MyUserPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) :UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = userRepository.findByUsername(username)
        if (user == null)
            throw UsernameNotFoundException("User 404")
        return MyUserPrincipal(user)
    }

    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    fun createUser(userRequest: UserRequest) : User{
        if(userRequest.firstName.isBlank() || userRequest.email.isBlank()) {
            throw BadRequestException("Invalid Request")
        }
        val user = UserConverter.convertToEntity(userRequest)
//        user.password = userSecurityConfig.passwordEncoder().encode(user.password)
        return userRepository.save(user)
    }

    fun getOneUser(id: Int) : User {
        return userRepository.getOne(id)
    }

    fun deleteOneUser (id: Int)  {
        userRepository.deleteById(id)
    }

    fun updateUser (userRequest: UserRequest): User{
        if(userRequest.id == null || userRequest.firstName.isBlank() || userRequest.email.isBlank()) {
            throw BadRequestException("Invalid Request")
        }
        val user = UserConverter.convertToEntity(userRequest)
        return userRepository.save(user)
    }

    fun searchByName(firstName: String) :User {
        return userRepository.findFirstByFirstName(firstName)
    }

    fun SearchByNameAndType(firstName: String, userType: UserType): User {
        return userRepository.findFirstByFirstNameAndUserType(firstName, userType)
    }

}