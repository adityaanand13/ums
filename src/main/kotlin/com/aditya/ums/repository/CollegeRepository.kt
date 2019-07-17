package com.aditya.ums.repository

import com.aditya.ums.entity.College
import org.springframework.data.jpa.repository.JpaRepository

interface CollegeRepository: JpaRepository<College, Int> {
    fun findFirstByName(name: String): College
}