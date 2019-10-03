package com.aditya.ums.api.payload
import javax.validation.constraints.*

class SignUpRequest(@NotBlank
                    @Size(min = 4, max = 40)
                    var firstName: String,

                    @NotBlank
                    @Size(min = 4, max = 40)
                    var lastName: String,

                    @NotBlank
                    @Size(min = 3, max = 15)
                    var username: String,

                    @NotBlank
                    @Size(max = 40)
                    @Email
                    var email: String,

                    @NotBlank
                    @Size(min = 6, max = 20)
                    var password: String
)