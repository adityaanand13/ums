package com.aditya.ums.api.request

import java.time.LocalDate

class StudentRequest (
    var rollNo : Int,
    var DOB: LocalDate,
    var batch : String,
    var localAddress: String,
    var nationality: String,
    var fathersName: String,
    var fathersPhone: String,
    var fathersIncome: Int,
    var fathersOccupation: String,
    var mothersName: String,
    var mothersPhone: String,
    var mothersIncome: Int? = 0,
    var mothersOccupation: String,
    var familyIncome: Int
)