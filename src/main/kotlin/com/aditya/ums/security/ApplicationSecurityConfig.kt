package com.aditya.ums.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.util.AntPathMatcher


@Configuration
@EnableWebSecurity
class ApplicationSecurityConfig: WebSecurityConfigurerAdapter() {

    @Qualifier("userService")
    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    @Bean
    fun authProvider() : AuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService)
        provider.setPasswordEncoder(BCryptPasswordEncoder())
        return provider
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/bower_components/**", "/*.js",
                        "/*.jsx", "/main.css").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .logout()
                .logoutSuccessUrl("/")
    }

//    override fun configure(http: HttpSecurity?) {
//        http?.
//                csrf()?.disable()?.
//                formLogin()?.
//                loginPage("/login")?.permitAll()?.
//                and()?.
//                logout()?.invalidateHttpSession(true)?.
//                clearAuthentication(true)?.
//                logoutRequestMatcher(AntPathRequestMatcher("/logout"))?.
//                logoutSuccessUrl("/logout-success")?.permitAll()
//    }
}
