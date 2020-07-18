package com.aditya.ums

import com.aditya.ums.service.UserService
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.Console


@Component
class ApplicationStartupRunner : CommandLineRunner {
    protected val logger: Log = LogFactory.getLog(javaClass)

    @Autowired lateinit var userService: UserService

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        if(userService.isSuperAdmin()){
            logger.info("super admin already exist")
        }else{
            try {
                // creates a console object
                val console: Console? = System.console()

                // if console is not null
                if (console != null) {
                    do {
                        println("Enter Super Admin Password")
                        val pwd1 = console.readPassword("Password: ")
                        val pwd2 = console.readPassword("Verify Password: ")
                        val p1 = String(pwd1)
                        val p2 = String(pwd2)
                        if (p1 == p2) {
                            println("Password verified")
                            println("creating user")
                            userService.createSuperUser(p1)
                            break
                        } else {
                            println("Password did not match, Try Again")
                        }
                    }while (true)
                }
            } catch (ex: java.lang.Exception) {
                // if any error occurs
                ex.printStackTrace()
            }
        }
        logger.info("ApplicationStartupRunner run method Started !!")
    }
}