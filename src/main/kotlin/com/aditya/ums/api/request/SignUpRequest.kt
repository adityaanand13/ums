package com.aditya.ums.api.request

import com.aditya.ums.enums.Gender
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(@NotBlank
                    @Size(min = 4, max = 40)
                    var firstname: String,

                         @NotBlank
                    @Size(min = 4, max = 40)
                    var lastname: String,

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

                         val dob: LocalDate,
                         val gender: Gender,
                         val phone: String
)