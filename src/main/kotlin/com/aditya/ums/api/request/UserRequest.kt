package com.aditya.ums.api.request

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserRequest (
    val id: Int,
    @NotBlank
    val username: String,

    @NotBlank
    val firstName: String,

    @NotBlank
    @Email
    val email: String,

    val lastName: String? = null,
    val DOB: LocalDate,
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
    val password: String
)