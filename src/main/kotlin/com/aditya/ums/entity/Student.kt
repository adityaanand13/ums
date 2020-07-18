package com.aditya.ums.entity

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "ID")
class Student(

        id: Int? = null,

        username: String?,

        password: String,

        firstName: String,

        lastName: String?,

        email: String,

        DOB: LocalDate,

        gender: Gender,

        phone: String,

        blood: Blood = Blood.UNDEFINED,

        religion: Religion = Religion.UNDEFINED,

        category: Category = Category.UNDEFINED,

        aadhar: Long,

        userType: UserType = UserType.STUDENT,

        address: String = "",

        city: String = "",

        state: String = "",

        pinCode: Int = 0,

        country: String = "India",

        roles: MutableList<Role> = mutableListOf<Role>(),


        @Column(name = "local_address")
        var localAddress: String = "",

        //todo refactoring nationality
        @Column(name = "nationality")
        var nationality: String = "Indian",

        //todo add ESM : Ex-Serviceman
        //todo add PHC : Physically handicapped

        //student family details
        @Column(name = "fathers_name")
        var fathersName: String = "",

        @Column(name = "fathers_phone")
        var fathersPhone: String = "",

        @Column(name = "fathers_income")
        var fathersIncome: Int = 0,

        @Column(name = "fathers_occupation")
        var fathersOccupation: String = "",

        @Column(name = "mothers_name")
        var mothersName: String = "",

        @Column(name = "mothers_phone")
        var mothersPhone: String = "",

        @Column(name = "mothers_income")
        var mothersIncome: Int = 0,

        @Column(name = "mothers_occupation")
        var mothersOccupation: String = "",

        @Column(name = "family_income")
        var familyIncome: Int = 0,

        // many students can have one Group
        @ManyToOne(
                cascade = [
                        CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.DETACH,
                        CascadeType.REFRESH
                ],
                fetch = FetchType.LAZY
        )
        @JoinTable(
                name = "student_group",
                joinColumns = [JoinColumn(name = "student_id")],
                inverseJoinColumns = [JoinColumn(name = "group_id")]
        )
        public var group: Group? = null

//    @OneToMany(mappedBy = "student_id")
//    var attendances: MutableList<Attendance> = arrayListOf()
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

