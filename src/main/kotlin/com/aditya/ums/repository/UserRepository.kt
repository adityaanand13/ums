package com.aditya.ums.repository

import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Int> {
    fun findByUsername(username: String?): User
    fun findFirstByFirstName(firstName : String): User
    fun findFirstByFirstNameAndUserType(firstName: String, userType: UserType): User
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(it: String): Boolean?
    fun findByUsernameOrEmail(usernameOrEmail: String, usernameOrEmail1: String): User
    fun findById(id: Long?): Optional<User>
}