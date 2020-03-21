package com.aditya.ums.api.response

class CollegeResponse (
        var id: Int?=null,
        var name: String,
        var description: String,
        var code: String,
        var address: String = "",
        var courses: List<CourseResponse>
)