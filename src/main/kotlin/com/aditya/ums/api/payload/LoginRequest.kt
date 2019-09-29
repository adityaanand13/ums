package com.aditya.ums.api.payload

import javax.validation.constraints.NotBlank

class LoginRequest(@NotBlank
                   var usernameOrEmail: String? = null,
                   @NotBlank
                   var password: String? = null)