package com.aditya.ums.service

import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.api.request.SubjectRequest
import com.aditya.ums.entity.Section
import com.aditya.ums.entity.Semester
import com.aditya.ums.entity.Subject
import com.aditya.ums.repository.SemesterRepository
import org.springframework.stereotype.Service

@Service
class SemesterService (
        private val semesterRepository: SemesterRepository,
        private val sectionService: SectionService,
        private val subjectService: SubjectService
) {

    fun getById(id: Int): Semester{
        return semesterRepository.getOne(id)
    }

    fun addSection(semesterID: Int, sectionRequest: SectionRequest): Semester {
        var semester = semesterRepository.getOne(semesterID)
        if(semester!= null){
            sectionRequest.name = (65+semester.sections.size).toChar().toString()
            val section: Section = sectionService.create(sectionRequest)
            section.semester=semester
            semester.sections.add(section)
            semester = semesterRepository.save(semester)
        }
        return semester
    }

    fun addSubject(semesterID: Int, subjectRequest: SubjectRequest): Semester {
        var semester = semesterRepository.getOne(semesterID)
        if(semester!= null){
            val subject: Subject = subjectService.create(subjectRequest)
            subject.semester=semester
            semester.subjects.add(subject)
            semester = semesterRepository.save(semester)
        }
        return semester
    }
}