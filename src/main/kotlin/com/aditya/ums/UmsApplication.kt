package com.aditya.ums

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UmsApplication

fun main(args: Array<String>) {
    runApplication<UmsApplication>(*args)
}
