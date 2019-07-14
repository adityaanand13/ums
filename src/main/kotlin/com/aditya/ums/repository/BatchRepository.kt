package com.aditya.ums.repository

import com.aditya.ums.entity.Batch
import org.springframework.data.jpa.repository.JpaRepository

interface BatchRepository: JpaRepository<Batch, Int> {
}