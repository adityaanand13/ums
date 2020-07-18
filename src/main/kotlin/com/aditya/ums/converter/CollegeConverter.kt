package com.aditya.ums.converter

import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.api.response.CollegeResponse
import com.aditya.ums.entity.College
import com.aditya.ums.entity.Instructor

class CollegeConverter {
    companion object {

        fun convertToResponses(colleges: List<College>): List<CollegeResponse> {
            return colleges.map { college -> convertToResponse(college) }
        }

        fun convertToResponse(college: College): CollegeResponse {
            return CollegeResponse(
                    id = college.id,
                    name = college.name,
                    code = college.code,
                    address = college.address,
                    phone = college.phone,
                    email = college.email
            )
        }

        fun convertToDetailedResponse(college: College, principal: Instructor?): CollegeResponse {
            return CollegeResponse(
                    id = college.id,
                    name = college.name,
                    code = college.code,
                    address = college.address,
                    phone = college.phone,
                    email = college.email,
                    principal = principal?.let {InstructorConverter.convertToResponse(instructor = it)},
                    courses = CourseConverter.convertToResponses(college.courses)

            )
        }

        fun convertToEntity(collegeRequest: CollegeRequest): College {
            return College(
                    name = collegeRequest.name,
                    address = collegeRequest.address,
                    code = collegeRequest.code,
                    phone = collegeRequest.phone,
                    email = collegeRequest.email
            )
        }
    }
}