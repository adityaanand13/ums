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

        blood: Blood,

        religion: Religion,

        category: Category,

        aadhar: Long,

        userType: UserType = UserType.STUDENT,

        address: String,

        city: String,

        state: String,

        pinCode: String,

        country: String,

        roles: MutableList<Role> = mutableListOf<Role>(),

        @Column(name = "roll_no")
        var rollNo: Int,

        @Column(name = "local_address")
        var localAddress: String,

        //todo refactoring nationality
        @Column(name = "nationality")
        var nationality: String,

        //todo add ESM : Ex-Serviceman
        //todo add PHC : Physically handicapped

        //student family details
        @Column(name = "fathers_name")
        var fathersName: String,

        @Column(name = "fathers_phone")
        var fathersPhone: String,

        @Column(name = "fathers_income")
        var fathersIncome: Int,

        @Column(name = "fathers_occupation")
        var fathersOccupation: String,

        @Column(name = "mothers_name")
        var mothersName: String,

        @Column(name = "mothers_phone")
        var mothersPhone: String,

        @Column(name = "mothers_income")
        var mothersIncome: Int = 0,

        @Column(name = "mothers_occupation")
        var mothersOccupation: String,

        @Column(name = "family_income")
        var familyIncome: Int = 0,

        // many students can have one Group
        @ManyToOne(
                cascade = [
                        CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.DETACH,
                        CascadeType.REFRESH
                ]
        )
        @JoinTable(
                name = "student_group",
                joinColumns = [JoinColumn(name = "student_id")],
                inverseJoinColumns = [JoinColumn(name = "group_id")]
        )
        private var group: Group? = null

//    @OneToMany(mappedBy = "student_id")
//    var attendances: MutableList<Attendance> = arrayListOf()
) : User(id, username, password, firstName, lastName, email, DOB, gender, phone, blood, religion, category, aadhar, userType, address, city, state, pinCode, country, roles)

