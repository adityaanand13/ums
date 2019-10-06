package com.aditya.ums.repository

import com.aditya.ums.entity.Student
import com.aditya.ums.enums.UserType
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Int> {
    fun findFirstByFirstNameAndUserType(firstName: String, userType: UserType): Student
}