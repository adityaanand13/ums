package com.aditya.ums.config

import com.aditya.ums.repository.UserRepository
import com.aditya.ums.security.UserPrincipal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailService
    (@Autowired val userRepository: UserRepository):
        UserDetailsService {

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(usernameOrEmail: String): UserDetails {
        // Let people login with either username or email
        val user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        //TODO(add exception handling")
//                .orElseThrow { UsernameNotFoundException("User not found with username or email : $usernameOrEmail") }

        return UserPrincipal.create(user)
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    fun loadUserById(id: Long?): UserDetails {
        val user = userRepository.findById(id).orElseThrow { UsernameNotFoundException("User not found with id : " + id!!) }

        return UserPrincipal.create(user)
    }
}