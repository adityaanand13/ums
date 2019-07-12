package com.aditya.ums.repository

import com.aditya.ums.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Int> {
}