package com.aditya.ums.api.payload

import com.aditya.ums.enums.Gender
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(@NotBlank
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
                    var password: String,

                         val DOB: LocalDate,
                         val gender: Gender,
                         val phone: String
)