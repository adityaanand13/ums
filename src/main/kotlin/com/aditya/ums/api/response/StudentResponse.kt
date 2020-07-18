package com.aditya.ums.api.response

import com.aditya.ums.enums.*
import java.time.LocalDate

class StudentResponse (
        var id: Int? = null,
        var username: String,
        var firstName: String,
        var lastName: String? = null,
        var dob: LocalDate? = null,
        var blood: Blood,
        var email: String,
        var phone: String,
        var gender: Gender,
        var religion : Religion,
        var category : Category,
        var aadhar: Long,

        var address: String,
        var city: String,
        var state: String,
        var pinCode: Int,
        var country: String,
        var localAddress: String ? = null,
        var nationality: String ? = null,

        var fathersName: String? = null,
        var fathersPhone: String? = null,
        var fathersIncome: Int? = null,
        var fathersOccupation: String? = null,
        var mothersName: String? = null,
        var mothersPhone: String? = null,
        var mothersIncome: Int? = 0,
        var mothersOccupation: String? = null,
        var familyIncome: Int? = null
)