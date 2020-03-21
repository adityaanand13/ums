package com.aditya.ums.converter

import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.api.response.SectionResponse
import com.aditya.ums.entity.Section

class SectionConverter {
    companion object{
        fun convertToResponses(sections: List<Section>): List<SectionResponse>{
            return sections.map { section -> convertToResponse(section) }
        }
        fun convertToEntity(sectionRequest: SectionRequest): Section{
            return Section(
                name = sectionRequest.name,
                description = sectionRequest.description
            )
        }
        fun convertToResponse(section: Section): SectionResponse{
            return SectionResponse(
                    id = section.id,
                    name = section.name,
                    description = section.description,
                    groups = GroupConverter.convertToResponses(section.groups)
            )
        }
    }
}