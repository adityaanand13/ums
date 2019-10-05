package com.aditya.ums.security

import com.aditya.ums.entity.User
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import kotlin.collections.ArrayList

class UserPrincipal(
        private var id :  Int?,
        private var name:  String,
        private var username: String,
        @JsonIgnore
        private var email: String,
        @JsonIgnore
        private var password: String,
        private val authorities: MutableCollection< GrantedAuthority> = ArrayList()
): UserDetails  {

    companion object{
        fun create(user: User): UserPrincipal {
            val authorities: MutableCollection< GrantedAuthority> = ArrayList()
            authorities.add(SimpleGrantedAuthority((user.userType.toString())))

            return UserPrincipal(
                    user.id,
                    user.firstName + user.lastName,
                    user.username,
                    user.email,
                    user.password,
                    authorities
            )
        }
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return username
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPassword(): String {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as UserPrincipal?
        return Objects.equals(id, that!!.id)
    }

    override fun hashCode(): Int {

        return Objects.hash(id)
    }

    fun getId(): Int? {
        return id
    }
}