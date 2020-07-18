package com.aditya.ums.repository

import com.aditya.ums.entity.Batch
import org.springframework.data.jpa.repository.JpaRepository

interface BatchRepository: JpaRepository<Batch, Int> {
    fun getAllByCourse_Id(course_id: Int): List<Batch>
    fun getByName(name: String): Batch
    fun existsByName(name: String): Boolean
}