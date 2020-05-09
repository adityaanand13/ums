package com.aditya.ums.converter

import com.aditya.ums.api.request.SubjectRequest
import com.aditya.ums.api.response.SubjectResponse

import com.aditya.ums.entity.Subject

class SubjectConverter {
    companion object {
        fun convertToResponses(subjects: List<Subject>): List<SubjectResponse> {
            return subjects.map { semester -> convertToResponse(semester) }
        }

        fun convertToEntity(subjectRequest: SubjectRequest): Subject {
            return Subject(
                    name = subjectRequest.name,
                    description = subjectRequest.description
            )
        }

        fun convertToResponse(subject: Subject): SubjectResponse {
            return SubjectResponse(
                    id = subject.id,
                    name = subject.name,
                    description = subject.description
            )
        }
    }
}