package com.aditya.ums.api.request

import com.aditya.ums.enums.Blood
import com.aditya.ums.enums.Category
import com.aditya.ums.enums.Gender
import com.aditya.ums.enums.Religion
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

class StudentRequest(
        val id: Int?, //
        @NotBlank
        val username: String,
        @NotBlank
        val firstName: String,
        @NotBlank
        val lastName: String,
        val dob: LocalDate,
        @NotBlank
        @Email
        val email: String,
        val gender: Gender,
        val phone: String,
        val blood: Blood,
        val religion: Religion,
        val category: Category,
        @PositiveOrZero
        val aadhar: Long = 0L,
        var localAddress: String,
        val address: String,
        val city: String,
        val state: String,
        @PositiveOrZero
        val pinCode: Int = 0,
        val country: String,
        val password: String,
        var nationality: String,
        var fathersName: String,
        var fathersPhone: String,
        var fathersOccupation: String,
        var fathersIncome: Int,
        var mothersName: String,
        var mothersPhone: String,
        var mothersOccupation: String,
        var mothersIncome: Int? = 0,
        var familyIncome: Int
)