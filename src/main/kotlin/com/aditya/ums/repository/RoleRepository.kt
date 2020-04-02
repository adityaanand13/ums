package com.aditya.ums.repository

import com.aditya.ums.entity.Role
import com.aditya.ums.enums.RoleType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Int?> {
    fun findByName(name: RoleType): Role
}