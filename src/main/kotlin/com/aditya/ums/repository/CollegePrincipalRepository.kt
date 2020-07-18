package com.aditya.ums.repository

import com.aditya.ums.entity.CollegePrincipal
import org.springframework.data.jpa.repository.JpaRepository

interface CollegePrincipalRepository: JpaRepository<CollegePrincipal, Int> {
}