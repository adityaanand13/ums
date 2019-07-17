package com.aditya.ums.converter

import com.aditya.ums.api.request.SemesterRequest
import com.aditya.ums.api.response.SemesterResponse
import com.aditya.ums.entity.Semester

class SemesterConverter {
    companion object{
        fun convertToResponse(semester: Semester): SemesterResponse{
            return SemesterResponse(
                name = semester.name,
                description = semester.description
            )
        }

        fun convertToEntity(semesterRequest: SemesterRequest): Semester{
            return Semester(
                name = semesterRequest.name,
                description = semesterRequest.description
            )
        }
    }
}