package com.aditya.ums.api.response

import java.time.LocalDate

class StudentResponse (
        var rollNo : Int = 0,
        var DOB: LocalDate? = null,
        var batch : String ? = null,
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
        var familyIncome: Int? = null,
        var userResponse: UserResponse
)