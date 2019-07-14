package com.aditya.ums.api.request

class CourseRequest (
    var id: Int,
    var name: String,
    var descrition: String,
    var duration: Int,
    var college: CollegeRequest
)