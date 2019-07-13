package com.aditya.ums.repository

import com.aditya.ums.entity.Instructor
import com.aditya.ums.enums.UserType
import org.springframework.data.jpa.repository.JpaRepository

interface InstructorRepository : JpaRepository<Instructor, Int> {
    fun findFirstByUserFirstNameAndUserUserType(firstName: String, userType: UserType): Instructor
    fun findFirstByEmployeeID(employeeID: Int): Instructor
}