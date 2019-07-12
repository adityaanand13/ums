package com.aditya.ums.repository

import com.aditya.ums.entity.Instructor
import org.springframework.data.jpa.repository.JpaRepository

interface InstructorRepository : JpaRepository<Instructor, Int> {
}