package com.aditya.ums.api.response

import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.api.request.UserRequest

class InstructorResponse (
        val employeeID: Int,
        val user: UserResponse,
        val coursesResponse:   List<CourseResponse>
)