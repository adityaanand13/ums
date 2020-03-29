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

    //todo send to security config
//    fun configure(http: HttpSecurity){
//        http.authorizeRequests()
//                .antMatchers("/actuator/health").permitAll().anyRequest().authenticated()
//    }

}
fun main(args: Array<String>) {
    runApplication<UmsApplication>(*args)
}
