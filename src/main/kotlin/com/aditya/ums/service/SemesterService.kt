package com.aditya.ums.service

import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.api.request.SemesterRequest
import com.aditya.ums.converter.SemesterConverter
import com.aditya.ums.entity.Section
import com.aditya.ums.entity.Semester
import com.aditya.ums.repository.SemesterRepository
import org.springframework.stereotype.Service

@Service
class SemesterService (
        private val semesterRepository: SemesterRepository,
        private val sectionService: SectionService
) {

    fun create (semesterRequest: SemesterRequest): Semester{
        return semesterRepository.save(SemesterConverter.convertToEntity(semesterRequest))
    }

    fun addSection(semesterID: Int, sectionRequest: SectionRequest): Semester {
        var semester = semesterRepository.getOne(semesterID)
        if(semester!= null){
            val section: Section = sectionService.create(sectionRequest)
            section.semester=semester
            semester.sections.add(section)
            semester = semesterRepository.save(semester)
        }
        return semester
    }
}