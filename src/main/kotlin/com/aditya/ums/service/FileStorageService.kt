package com.aditya.ums.service

import com.aditya.ums.config.FileStorageProperties
import com.aditya.ums.exception.FileStorageException
import com.aditya.ums.exception.MyFileNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption


@Service
class FileStorageService (
        @Autowired private val fileStorageProperties: FileStorageProperties
) {

    private val fileStorageLocation: Path = Paths.get(fileStorageProperties.getUploadDir()!!)
            .toAbsolutePath().normalize()

    fun storeFile(file: MultipartFile): String? {
        // Normalize file name
        val fileName: String? = file.originalFilename?.let { StringUtils.cleanPath(it) }
        return try {
            // Check if the file's name contains invalid characters
            if (fileName != null) {
                if (fileName.contains("..")) {
                    throw FileStorageException("Sorry! Filename contains invalid path sequence $fileName")
                }
            }

            // Copy file to the target location (Replacing existing file with the same name)
            val targetLocation: Path = fileStorageLocation.resolve(fileName)
            Files.copy(file.inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING)
            fileName
        } catch (ex: IOException) {
            throw FileStorageException("Could not store file $fileName. Please try again!", ex)
        }
    }

    fun loadFileAsResource(fileName: String): Resource {
        return try {
            val filePath: Path = fileStorageLocation.resolve(fileName).normalize()
            val resource: Resource = UrlResource(filePath.toUri())
            if (resource.exists()) {
                resource
            } else {
                throw MyFileNotFoundException("File not found $fileName")
            }
        } catch (ex: MalformedURLException) {
            throw MyFileNotFoundException("File not found $fileName", ex)
        }
    }

    init {
        try {
            Files.createDirectories(fileStorageLocation)
        } catch (ex: Exception) {
            throw FileStorageException("Could not create the directory where the uploaded files will be stored.", ex)
        }
    }
}