package com.aditya.ums.service

import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.converter.SectionConverter
import com.aditya.ums.entity.Group
import com.aditya.ums.entity.Section
import com.aditya.ums.repository.SectionRepository
import org.springframework.stereotype.Service

@Service
class SectionService (
        private val sectionRepository: SectionRepository,
        private val groupService: GroupService
){
    fun create(sectionRequest: SectionRequest): Section{
        return sectionRepository.save(SectionConverter.convertToEntity(sectionRequest))
    }

    fun getById(id: Int): Section{
        return sectionRepository.getOne(id)
    }

    fun addGroup(sectionID: Int): Section {
        var section = sectionRepository.getOne(sectionID)
        if(section!= null){
            val group: Group = groupService.create("${section.name}${section.groups.size+1}")
            group.section= section
            section.groups.add(group)
            section = sectionRepository.save(section)
        }
        return section
    }
}