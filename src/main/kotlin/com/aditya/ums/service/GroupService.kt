package com.aditya.ums.service

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.entity.Group
import com.aditya.ums.entity.Student
import com.aditya.ums.repository.GroupRepository
import org.springframework.stereotype.Service

@Service
class GroupService(
        private val groupRepository: GroupRepository,
        private val studentService: StudentService
) {
    fun create(name: String): Group {
        val group: Group = Group(name = name)
        return groupRepository.save(group)
    }

    fun getById(groupId: Int) : Group{
        return groupRepository.getOne(groupId)
    }

    fun addStudent(groupId: Int, studentRequest: StudentRequest): Group {
        val group : Group = groupRepository.getOne(groupId)
        val student = studentService.create(studentRequest)
        group.students.add(student)
        return groupRepository.save(group)
    }

    fun getStudents(groupId: Int): List<Student> {
        return groupRepository.getOne(groupId).students
    }

}