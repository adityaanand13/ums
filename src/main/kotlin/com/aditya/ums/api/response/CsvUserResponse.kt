package com.aditya.ums.api.response

import com.aditya.ums.enums.Gender
import java.time.LocalDate

class CsvUserResponse (
        var username: String,
        var firstName: String,
        var lastName: String,
        var email: String,
        var DOB: String,
        var gender: String,
        var phone: String,
        var country: String
)
