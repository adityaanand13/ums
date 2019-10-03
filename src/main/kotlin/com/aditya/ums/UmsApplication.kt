package com.aditya.ums

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["com.aditya.ums.config", "com.aditya.ums.service", "com.aditya.ums.repository", "com.aditya.ums.security", "com.aditya.ums.api.controller"])
class UmsApplication{
    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

}
fun main(args: Array<String>) {
    runApplication<UmsApplication>(*args)
}
