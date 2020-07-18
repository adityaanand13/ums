package com.aditya.ums.converter

import com.aditya.ums.api.request.GroupRequest
import com.aditya.ums.api.response.GroupResponse
import com.aditya.ums.entity.Group

class GroupConverter {
    companion object {
        fun convertToResponses(groups: List<Group>): List<GroupResponse> {
            return groups.map { group -> convertToResponse(group) }
        }

        fun convertToResponse(group: Group): GroupResponse {
            return GroupResponse(
                    id = group.id,
                    name = group.name
            )
        }

        fun convertToDetailedResponse(group: Group): GroupResponse {
            return GroupResponse(
                    id = group.id,
                    name = group.name,
                    students = StudentConverter.convertToResponses(group.students)
            )
        }

        fun convertToEntity(groupRequest: GroupRequest): Group {
            return Group(
                    id = groupRequest.id,
                    name = groupRequest.name
            )
        }
    }
}