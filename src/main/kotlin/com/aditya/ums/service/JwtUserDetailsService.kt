//package com.aditya.ums.service
//
//import java.util.ArrayList
//
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.stereotype.Service
//import org.apache.tomcat.jni.SSL.setPassword
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.beans.factory.annotation.Autowired
//import com.aditya.ums.entity.User as UserEntity
//
//
//
//
//
//@Service
//class JwtUserDetailsService (
//        @Autowired private val userEntity: UserEntity? = null,
//        @Autowired private val bcryptEncoder: PasswordEncoder? = null): UserDetailsService {
//
//    @Throws(UsernameNotFoundException::class)
//    override fun loadUserByUsername(username: String?): UserDetails {
//        return if ("javainuse" == username) {
//            User("javainuse", "$2a$10\$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    ArrayList())
//        } else {
//            throw UsernameNotFoundException("User not found with username: $username")
//        }
//    }
//
////    fun save(userEntity: UserEntity): UserEntity {
////        val newUser = UserEntity()
////        newUser.setUsername(user.getUsername())
////        newUser.setPassword(bcryptEncoder.encode(user.getPassword()))
////        return userDao.save(newUser)
////    }
//}