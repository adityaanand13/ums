package com.aditya.ums.repository

import com.aditya.ums.entity.Principal
import org.springframework.data.jpa.repository.JpaRepository

interface PrincipalRepository: JpaRepository<Principal, Int> {
}