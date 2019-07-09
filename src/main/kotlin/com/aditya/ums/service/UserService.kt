package com.aditya.ums.service

import com.aditya.ums.api.BadRequestException
import com.aditya.ums.api.request.UserRequest
import com.aditya.ums.entity.User
import com.aditya.ums.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (
        private val userRepository: UserRepository
) {
    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    fun createUser(userRequest: UserRequest) : User{
        if(userRequest.firstName.isBlank() || userRequest.email.isBlank()) {
            throw BadRequestException("Invalid Request")
        }
        val user = User(
            firstName = userRequest.firstName,
            lastName = userRequest.lastName,
            email = userRequest.email
        )
        return userRepository.save(user)
    }

    fun getOneUser(id: Int) : User {
        return userRepository.getOne(id)
    }

    fun deleteOneUser (id: Int)  {
        userRepository.deleteById(id)
    }

    fun updateUser (userRequest: UserRequest): User {
        if(userRequest.id == null || userRequest.firstName.isBlank() || userRequest.email.isBlank()) {
            throw BadRequestException("Invalid Request")
        }
        val user = User(
                firstName = userRequest.firstName,
                lastName = userRequest.lastName,
                email = userRequest.email
        )
        return userRepository.save(user)
    }

    fun searchByName(firstName: String) :User {
        return userRepository.findFirstByFirstName(firstName)
    }

}