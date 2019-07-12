package com.aditya.ums.api.request

class InstructorRequest (
    val employeeID: Int,
    val user: UserRequest,
    val coursesRequest:  List<CourseRequest>
)