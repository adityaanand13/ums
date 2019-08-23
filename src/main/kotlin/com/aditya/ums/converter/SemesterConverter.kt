package com.aditya.ums.converter

import com.aditya.ums.api.request.SemesterRequest
import com.aditya.ums.api.response.SemesterResponse
import com.aditya.ums.entity.Semester

class SemesterConverter {
    companion object{
        fun convertToResponses(semesters: List<Semester>): List<SemesterResponse>{
            return semesters.map { semester -> convertToResponse(semester) }
        }
        fun convertToResponse(semester: Semester): SemesterResponse{
            return SemesterResponse(
                id = semester.id,
                name = semester.name,
                description = semester.description,
                sections = SectionConverter.convertToResponses(semester.sections)
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