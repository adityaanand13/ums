package com.aditya.ums.config

import com.aditya.ums.security.UserPrincipal
import org.springframework.data.domain.AuditorAware
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

class SpringSecurityAuditAwareImpl : AuditorAware<Long> {
    override fun getCurrentAuditor(): Optional<Long> {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication == null ||
                !authentication.isAuthenticated ||
                authentication is AnonymousAuthenticationToken) {
            return Optional.empty<Long>()
        }
        val userPrincipal = authentication.principal as UserPrincipal
        return Optional.of(userPrincipal.id.toLong())
    }
}