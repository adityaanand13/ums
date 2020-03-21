package com.aditya.ums.entity

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "instructor")
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

        aadhar: Long,

        userType: UserType,

        address: String,

        city: String,

        state: String,

        pinCode: String,

        country: String,

        roles: MutableSet<Role> = mutableSetOf<Role>(),


        @Column(name = "employee_id")
        var employeeID: Int

/*
    refers to instructor property in the course class @ JoinColumn
     to help find the associated courses for the instructor
     the delete cascade is not defined because
     when we want to delete the course we dont want to delete the instructor and vice versa
 */
//    @OneToMany(
//        mappedBy = "instructor",
//        cascade = [
//            CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.PERSIST,
//            CascadeType.REFRESH
//        ]
//    )//        fetch = FetchType.EAGER,
//    var courses: MutableList<Course>? = null
) : User(id, username, password, firstName, lastName, email, DOB, gender, phone, blood, religion, category, aadhar, userType, address, city, state, pinCode, country, roles)

