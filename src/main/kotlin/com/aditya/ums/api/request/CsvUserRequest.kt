package com.aditya.ums.api.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CsvUserRequest(
        @NotBlank
        @Size(min = 3, max = 15)
        var username: String,

        @NotBlank
        @Size(min = 4, max = 40)
        var firstname: String,

        @NotBlank
        @Size(min = 4, max = 40)
        var lastname: String,

        @NotBlank
        @Size(max = 40)
        @Email
        var email: String,

        @NotBlank
        @Size(min = 6, max = 20)
        var country: String,

        val DOB: String,
        val gender: String,
        val phone: String,
        val aadhar: Long
)