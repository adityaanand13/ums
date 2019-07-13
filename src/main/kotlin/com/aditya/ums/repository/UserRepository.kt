package com.aditya.ums.repository

import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun findFirstByFirstName(firstName : String): User

//    @Query("SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(:name)")
    fun findFirstByFirstNameAndUserType(firstName: String, userType: UserType): User
}