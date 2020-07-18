package com.aditya.ums.api.controller

import com.aditya.ums.service.FileStorageService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/download")
class FileDownloadController (
        @Autowired private val fileStorageService: FileStorageService){

    @GetMapping("/template/csv/student", produces = ["text/csv"])
    fun studentAddTemplate(): ResponseEntity<Resource> {
        val resource : Resource= fileStorageService.loadFileAsResource("StudentUploadTemplate.csv");
        logger.info("File downloaded", resource)
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/csv"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.filename + "\"")
                .body(resource)
    }

    @GetMapping("/template/excel/student", produces = ["application/vnd.openxmlformats-officedocument.spreadsheetml.template"])
    fun studentExcelTemplate(): ResponseEntity<Resource> {
        val resource : Resource= fileStorageService.loadFileAsResource("StudentDetail.xltx");
        logger.info("File downloaded", resource)
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.template"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.filename + "\"")
                .body(resource)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FileDownloadController::class.java)
    }
}