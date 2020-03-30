package com.aditya.ums.entity

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "principal")
@PrimaryKeyJoinColumn(name = "ID")
class Principal(
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

        aadhar: Long,

        userType: UserType,

        address: String,

        city: String,

        state: String,

        pinCode: String,

        country: String,

        roles: MutableList<Role> = mutableListOf<Role>(),

        @Column(name = "employee_id")
        var employeeID: Int,

        //principal role needs to have a college
        @OneToOne(
                cascade = [
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
                ]
        )
        @JoinColumn(name = "college_id")
        var college: College

) : User(id, username, password, firstName, lastName, email, DOB, gender, phone, blood, religion, category, aadhar, userType, address, city, state, pinCode, country, roles)


