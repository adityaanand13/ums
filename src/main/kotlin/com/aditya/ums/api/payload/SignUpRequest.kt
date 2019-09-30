package com.aditya.ums.api.payload

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.validation.constraints.*

class SignUpRequest(@NotBlank
                    @Size(min = 4, max = 40)
                    var firstName: String? = null,

                    @NotBlank
                    @Size(min = 4, max = 40)
                    var lastName: String? = null,

                    @NotBlank
                    @Size(min = 3, max = 15)
                    var username: String? = null,

                    @NotBlank
                    @Size(max = 40)
                    @Email
                    var email: String? = null,

                    @NotBlank
                    @Size(min = 6, max = 20)
                    var password: String? = null
)