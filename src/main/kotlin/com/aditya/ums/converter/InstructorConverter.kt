package com.aditya.ums.converter

import com.aditya.ums.api.response.CourseResponse
import com.aditya.ums.api.response.InstructorResponse
import com.aditya.ums.entity.Instructor

class InstructorConverter {
    companion object {
        fun convertToResponse (instructor: Instructor) : InstructorResponse{
            var courseResponses : List<CourseResponse>
            courseResponses = ArrayList()
            for (course in instructor.courses){
                courseResponses.add(CourseConverter.convertToResponse(course))
            }
            return InstructorResponse(
                    employeeID = instructor.employeeID,
                    user = UserConverter.convertToResponse(instructor.user),
                    coursesResponse = courseResponses
            )
        }
    }
}