package com.aditya.ums.service

import com.aditya.ums.api.request.SubjectRequest
import com.aditya.ums.converter.SubjectConverter
import com.aditya.ums.entity.Subject
import com.aditya.ums.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectService(
        private val subjectRepository: SubjectRepository
){
    fun create(subjectRequest: SubjectRequest): Subject{
        return subjectRepository.save(SubjectConverter.convertToEntity(subjectRequest))
    }
    fun getById(id: Int): Subject{
        return subjectRepository.getOne(id)
    }
}