package com.aditya.ums.repository

import com.aditya.ums.entity.Attendance
import org.springframework.data.jpa.repository.JpaRepository

interface AttendanceRepository : JpaRepository<Attendance, Int>