package com.aditya.ums.repository

import com.aditya.ums.entity.Subject
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository: JpaRepository<Subject, Int> {
}