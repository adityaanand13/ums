package com.aditya.ums.config

import com.aditya.ums.security.JwtAuthenticationEntryPoint
import com.aditya.ums.security.JwtAuthenticationFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.BeanIds
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

class SecurityConfig: WebSecurityConfigurerAdapter() {
    @Autowired val customUserDetailsService: CustomUserDetailService? = null

    @Autowired val unauthorizedHandler: JwtAuthenticationEntryPoint? = null

    @Bean
    fun jwtAuthenticationFilter(): JwtAuthenticationFilter {
        return JwtAuthenticationFilter()
    }

    @Throws(Exception::class)
    public override fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder())
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}