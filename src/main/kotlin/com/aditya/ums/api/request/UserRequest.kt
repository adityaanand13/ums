package com.aditya.ums.api.request

import com.aditya.ums.enums.*

class UserRequest (
    val id: Int,
    val firstName: String,
    val lastName: String? = null,
    val email: String,
    val gender: Gender,
    val phone: String,
    val blood: Blood,
    val religion: Religion,
    val category: Category,
    val aadhar: Long,
    val userType: UserType,
    val address: String,
    val city: String,
    val state: String,
    val pinCode: String,
    val country: String,
    val password: String,
    val student: StudentRequest
)