package com.aditya.ums.api.request

class StudentRequest (
    var rollNo : Int,
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
    var familyIncome: Int,

    val user: UserRequest
    //user ayega
    //student service
    //create user pehle... 
)