package com.aditya.ums.api.controller

import com.aditya.ums.api.response.Response
import com.aditya.ums.service.FileStorageService
import com.aditya.ums.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping("/api/admin")
@ResponseBody
@PreAuthorize("hasRole('ROLE_ADMIN')")
class AdminController(
        @Autowired private val userService: UserService,
        @Autowired private val fileStorageService: FileStorageService){


    //college controller authorised in college
    @PostMapping("/addMultipleUsers")
    fun uploadStudentFile(@RequestParam("file") file: MultipartFile): ResponseEntity<Response> {

        if (file.isEmpty){
            val response = Response()
                    .success(false)
                    .contentType("application/json")
                    .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .errors("File Cannot be empty")
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }else{
            val data = userService.createUserByCsv(file)
            val response = Response()
                    .success(true)
                    .data(data)
                    .contentType("application/json")
                    .httpStatusCode(HttpStatus.OK.value())
                    .statusMessage("success")
            return ResponseEntity(response, HttpStatus.OK)
        }
    }
}