package com.aditya.ums.repository

import com.aditya.ums.entity.Semester
import org.springframework.data.jpa.repository.JpaRepository

interface SemesterRepository: JpaRepository<Semester, Int>