package com.aditya.ums.api.response

class CollegeResponse (
        var id: Int?=null,
        var name: String,
        var code: String,
        var address: String,
        var phone: String,
        var email: String,
        var courses: List<CourseResponse>? = null
)