package com.aditya.ums.service

import com.aditya.ums.entity.College
import com.aditya.ums.entity.Instructor
import com.aditya.ums.entity.Principal
import com.aditya.ums.entity.Role
import com.aditya.ums.enums.RoleType
import com.aditya.ums.enums.UserType
import com.aditya.ums.repository.PrincipalRepository
import com.aditya.ums.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class PrincipalService (
        private val principalRepository: PrincipalRepository,
        private val roleRepository: RoleRepository
){
    fun create(instructor: Instructor, college: College): Principal {
        instructor.userType = UserType.PRINCIPAL
        instructor.roles.add(roleRepository.findByName(RoleType.ROLE_PRINCIPAL))
        //todo college repo and instructor repo save
        return principalRepository.save(Principal(instructor = instructor, college = college))
    }
}