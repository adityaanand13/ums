package com.aditya.ums.repository

import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun findByUsername(username: String): User
    fun findAllByUserType(userType: UserType): List<User>
    fun findFirstByFirstName(firstName : String): User
    fun findFirstByFirstNameAndUserType(firstName: String, userType: UserType): User
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(it: String): Boolean
    fun findByUsernameOrEmail(username: String, email: String): User
}