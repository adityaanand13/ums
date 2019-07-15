package com.aditya.ums.repository

import com.aditya.ums.entity.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Int> {
    fun getAllByCollege_Id(collegeId: Int): List<Course>
}