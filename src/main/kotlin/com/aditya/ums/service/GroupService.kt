package com.aditya.ums.service

import com.aditya.ums.api.request.GroupRequest
import com.aditya.ums.converter.GroupConverter
import com.aditya.ums.entity.Group
import com.aditya.ums.repository.GroupRepository
import org.springframework.stereotype.Service

@Service
class GroupService(
        private val groupRepository: GroupRepository
) {
    fun create(groupRequest: GroupRequest): Group{
        return groupRepository.save(GroupConverter.convertToEntity(groupRequest))
    }
}