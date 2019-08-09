package com.aditya.ums.api.request

import java.io.Serializable


class JwtRequest (
        val username: String? = null,
        val password: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 5926468583005150707L
    }
}