package com.aditya.ums

import com.aditya.ums.config.FileStorageProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["com.aditya.ums"])
@EnableConfigurationProperties(FileStorageProperties::class)
class UmsApplication{
    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

}
fun main(args: Array<String>) {
    runApplication<UmsApplication>(*args)
}
