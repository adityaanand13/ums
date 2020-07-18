package com.aditya.ums.api.response

import com.aditya.ums.enums.*
import java.time.LocalDate

//todo refactor instructor response
class InstructorResponse (
        var id: Int? = null,
        var username: String,
        var firstName: String,
        var lastName: String? = null,
        var email: String,
        var dob: LocalDate,
        var gender: Gender,
        var phone: String,
        var blood: Blood,
        var religion : Religion,
        var category : Category,
        var aadhar: Long,
        var userType: UserType,
        var address: String,
        var city: String,
        var state: String,
        var pinCode: Int,
        var country: String
)