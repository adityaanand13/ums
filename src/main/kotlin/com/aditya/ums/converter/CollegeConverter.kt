package com.aditya.ums.converter

import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.entity.College

class CollegeConverter {
    companion object{
        fun convertToEntity(collegeRequest:CollegeRequest): College{
            return College(
                id = collegeRequest.id,
                name = collegeRequest.name,
                description = collegeRequest.descrition
            )
        }
    }
}