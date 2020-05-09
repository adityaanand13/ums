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
    fun create(name: String): Group {
        val group: Group = Group(name = name)
        return groupRepository.save(group)
    }
}