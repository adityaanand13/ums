package com.aditya.ums

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["com.aditya.ums"])
class UmsApplication{
    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

}
fun main(args: Array<String>) {
    runApplication<UmsApplication>(*args)
}
