package com.aditya.ums.repository

import com.aditya.ums.entity.Instructor
import com.aditya.ums.enums.UserType
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface InstructorRepository : JpaRepository<Instructor, Int> {
    fun findFirstByFirstNameAndUserType(firstName: String, userType: UserType): Instructor
    fun findByUsername(username: String): Instructor?

    @Query("SELECT id, username FROM Instructor WHERE username LIKE %:val% ORDER BY username ASC")
    fun autocompleteUsername(@Param("val") username: String, pageable: Pageable = PageRequest.of(0, 15)): List<Array<Any>>
}