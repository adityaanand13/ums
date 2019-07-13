package com.aditya.ums.repository

import com.aditya.ums.entity.Student
import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Int> {
    fun findFirstByUserFirstNameAndUserUserType(firstName: String, userType: UserType): Student
}