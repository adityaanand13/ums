package com.aditya.ums.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "file")
class FileStorageProperties {
    private var uploadDir: String? = null

    fun getUploadDir(): String? {
        return uploadDir
    }

    fun setUploadDir(uploadDir: String?) {
        this.uploadDir = uploadDir
    }
}
