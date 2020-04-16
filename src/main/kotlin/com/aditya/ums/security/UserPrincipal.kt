package com.aditya.ums.security

import com.aditya.ums.entity.Role
import com.aditya.ums.entity.User
import com.aditya.ums.exception.BadRequestException
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

class UserPrincipal(
        val id: Int,
        val name: String,
        private val username: String,
        @field:JsonIgnore val email: String,
        @field:JsonIgnore private val password: String,
        private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    override fun getUsername(): String {
        return username
    }

    override fun getPassword(): String {
        return password
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as UserPrincipal
        return id == that.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    companion object {
        fun create(user: User): UserPrincipal {
            val authorities: List<GrantedAuthority> = user.roles.stream().map { role: Role -> SimpleGrantedAuthority(role.name?.name) }.collect(Collectors.toList())
            return UserPrincipal(
                    user.id!!,
                    user.firstName + user.lastName,
                    user.username!!,
                    user.email,
                    user.password,
                    authorities
            )
        }
    }
}