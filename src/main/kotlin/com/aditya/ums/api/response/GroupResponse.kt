package com.aditya.ums.api.response

class GroupResponse (
    var id : Int? =null,
    var name: String,
    var students : List<StudentResponse>? = null
)