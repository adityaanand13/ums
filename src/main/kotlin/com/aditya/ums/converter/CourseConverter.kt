package com.aditya.ums.converter

import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.api.response.CourseResponse
import com.aditya.ums.entity.Course

class CourseConverter {
    companion object {

        fun convertToResponses(courses: List<Course>): List<CourseResponse>{
            return courses.map { course -> convertToResponse(course) }
        }

        fun convertToResponse(course: Course) : CourseResponse{
            return CourseResponse(
                    name = course.name,
                    description = course.description
            )
        }

        fun convertToEntity(courseRequest: CourseRequest): Course{
            return Course(
                    name = courseRequest.name,
                    description = courseRequest.descrition
            )
        }
    }
}