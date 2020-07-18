package com.aditya.ums.api.request

import com.aditya.ums.enums.Blood
import com.aditya.ums.enums.Category
import com.aditya.ums.enums.Gender
import com.aditya.ums.enums.Religion
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

class InstructorRequest(
        val id: Int? = null,
        @NotBlank
        val username: String,
        @NotBlank
        val firstName: String,
        @NotBlank
        @Email
        val email: String,
        @NotBlank
        val lastName: String,
        val dob: LocalDate,
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