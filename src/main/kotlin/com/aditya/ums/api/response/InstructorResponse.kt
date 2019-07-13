package com.aditya.ums.api.response

class InstructorResponse (
        val employeeID: Int,
        val user: UserResponse,
        val coursesResponses: List<CourseResponse>?= null
)