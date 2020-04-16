package com.aditya.ums

import com.aditya.ums.config.FileStorageProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["com.aditya.ums"])
@EnableConfigurationProperties(FileStorageProperties::class)
@EnableSwagger2
class UmsApplication{
    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

//    @Bean
//    public fun swaggerConfiguration(): Docket {
//        return Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .paths(PathSelectors.ant("*/api/*"))
////                .apis(RequestHandlerSelectors.basePackage("com.aditya.ums "))
//                .build()
//    }

    //todo send to security config
//    fun configure(http: HttpSecurity){
//        http.authorizeRequests()
//                .antMatchers("/actuator/health").permitAll().anyRequest().authenticated()
//    }

}
fun main(args: Array<String>) {
    runApplication<UmsApplication>(*args)
}
