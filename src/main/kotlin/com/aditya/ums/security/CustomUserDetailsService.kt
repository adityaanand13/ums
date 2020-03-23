package com.aditya.ums.security

import com.aditya.ums.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService : UserDetailsService{

    @Autowired
    var userRepository: UserRepository? = null

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(usernameOrEmail: String): UserDetails? {
        // Let people login with either username or email
        val user = userRepository!!.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        if (user == null) {
            UsernameNotFoundException("User not found with username or email : $usernameOrEmail")
        }
        return UserPrincipal.create(user)
    }

    @Transactional
    fun loadUserById(id: Long): UserDetails? {
        val user = userRepository!!.findById(id.toInt()).orElse(null)
        return UserPrincipal.create(user)
    }

}