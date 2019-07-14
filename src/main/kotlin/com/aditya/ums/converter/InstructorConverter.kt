package com.aditya.ums.converter

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.api.response.CourseResponse
import com.aditya.ums.api.response.InstructorResponse
import com.aditya.ums.entity.Instructor
import com.aditya.ums.entity.User

class InstructorConverter {
    companion object {
        fun convertToResponses(instructors: List<Instructor> ): List<InstructorResponse>{
            return instructors.map { instructor ->  convertToResponse(instructor)}
        }

        fun convertToResponse (instructor: Instructor) : InstructorResponse{
            return InstructorResponse(
                    employeeID = instructor.employeeID,
                    user = UserConverter.convertToResponse(instructor.user)
            )
        }

        fun convertToEntity(instructorRequest: InstructorRequest, user: User): Instructor{
            return Instructor(
                user = user,
                employeeID = instructorRequest.employeeID
            )
        }
    }
}