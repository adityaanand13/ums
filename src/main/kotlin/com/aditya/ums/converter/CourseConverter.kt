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
                    id = course.id,
                    name = course.name,
                    description = course.description,
                    duration = course.duration,
                    batches = BatchConverter.convertToResponses(course.batches)
            )
        }

        fun convertToEntity(courseRequest: CourseRequest): Course{
            return Course(
                    id = courseRequest.id,
                    name = courseRequest.name,
                    description = courseRequest.description,
                    duration = courseRequest.duration
            )
        }
    }
}