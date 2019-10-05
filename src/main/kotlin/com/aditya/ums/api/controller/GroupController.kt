package com.aditya.ums.api.controller

import com.aditya.ums.service.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/group")
@ResponseBody
class GroupController(
        @Autowired private val groupService: GroupService
)