package com.aditya.ums.entity

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.Table

@Entity
@Table(name = "instructor")
@PrimaryKeyJoinColumn(name = "id")
class Instructor(

        id: Int = 0,

        username: String?,

        password: String,

        firstName: String,

        lastName: String?,

        email: String,

        DOB: LocalDate,

        gender: Gender,

        phone: String,

        blood: Blood,

        religion: Religion,

        category: Category,

        aadhar: Long = 0,

        userType: UserType = UserType.INSTRUCTOR,

        address: String,

        city: String,

        state: String,

        pinCode: Int,

        country: String,

        roles: MutableList<Role> = mutableListOf<Role>(),

        @Column(name = "principal")
        var principal: Boolean? = false,

        @Column(name = "headMentor")
        var headMentor: Boolean? = false,

        @Column(name = "mentor")
        var mentor: Boolean? = false
) : User(
        id = id,
        username = username,
        password = password,
        firstName = firstName,
        lastName = lastName,
        email = email,
        DOB = DOB,
        gender = gender,
        phone = phone,
        blood = blood,
        religion = religion,
        category = category,
        aadhar = aadhar,
        userType = userType,
        address = address,
        city = city,
        state = state,
        pinCode = pinCode,
        country = country,
        roles = roles
)

