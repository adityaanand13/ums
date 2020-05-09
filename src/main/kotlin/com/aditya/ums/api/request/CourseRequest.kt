package com.aditya.ums.api.request

class CourseRequest (
    var id: Int,
    var name: String,
    var code: String,
    var description: String,
    var duration: Int,
    var semesterPerYear: Int
)