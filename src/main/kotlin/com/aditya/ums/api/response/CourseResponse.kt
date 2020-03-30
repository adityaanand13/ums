package com.aditya.ums.api.response

class CourseResponse(
        var id: Int?= null,
        var name : String,
        var code: String,
        var description: String,
        var duration: Int,
        var batches: List<BatchResponse>
)