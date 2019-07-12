package com.aditya.ums.converter

import com.aditya.ums.api.response.CourseResponse
import com.aditya.ums.entity.Course

class CourseConverter {
    companion object {
        fun convertToResponse(course: Course) : CourseResponse{
            return CourseResponse(
                    name = course.name,
                    description = course.description
            )
        }
    }
}