package com.aditya.ums.repository

import com.aditya.ums.entity.Group
import org.springframework.data.jpa.repository.JpaRepository

interface GroupRepository: JpaRepository<Group, Int>