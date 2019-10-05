package com.aditya.ums.repository

import com.aditya.ums.entity.Section
import org.springframework.data.jpa.repository.JpaRepository

interface SectionRepository: JpaRepository<Section, Int>