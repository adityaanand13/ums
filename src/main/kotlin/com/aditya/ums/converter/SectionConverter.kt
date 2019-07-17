package com.aditya.ums.converter

import com.aditya.ums.api.request.SectionRequest
import com.aditya.ums.entity.Section

class SectionConverter {
    companion object{
        fun convertToEntity(sectionRequest: SectionRequest): Section{
            return Section(
                name = sectionRequest.name,
                description = sectionRequest.description
            )
        }
    }
}