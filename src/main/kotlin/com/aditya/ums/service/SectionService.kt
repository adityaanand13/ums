package com.aditya.ums.service

import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.converter.SectionConverter
import com.aditya.ums.entity.Section
import com.aditya.ums.repository.SectionRepository
import org.springframework.stereotype.Service

@Service
class SectionService (
        private val sectionRepository: SectionRepository
){
    fun create(sectionRequest: SectionRequest): Section{
        return sectionRepository.save(SectionConverter.convertToEntity(sectionRequest))
    }
}