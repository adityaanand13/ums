package com.aditya.ums.api.request

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

open class UserRequest (
    val id: Int?,
    @NotBlank
    val username: String,
    @NotBlank
    val firstName: String,
    @NotBlank
    @Email
    val email: String,
    @NotBlank
    val lastName: String,
    val DOB: LocalDate,
    val gender: Gender,
    val phone: String,
    val blood: Blood,
    val religion: Religion,
    val category: Category,
    @PositiveOrZero
    val aadhar: Long = 0L,
    val address: String,
    val city: String,
    val state: String,
    @PositiveOrZero
    val pinCode: Int = 0,
    val country: String,
    val password: String
)